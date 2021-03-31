
/*
* <p> Source File Name: ExProductService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.ExProduct;
import com.neux.garden.ec.runtime.jpa.model.ExProductCategoryMapping;
import com.neux.garden.ec.runtime.jpa.model.ExProductPoint;
import com.neux.garden.ec.runtime.service.DateService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExProductService<T> extends ExProductBasicService {

    private Logger logger = LoggerFactory.getLogger(ExProductService.class);

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ExProductPointService exProductPointService;

    @Autowired
    private ExProductCategoryMappingService exProductCategoryMappingService;

    @Autowired
    private DateService dateService;

    public ExProduct findByProductId(String productId) {
        return basicExProduct.findByProductId(productId);
    }

    public Page<ExProduct> listProducts(String categoryId, String keyword, String productId, String minPoint, String maxPoint,int pageNo) {

        final Set<String> productIdSet = new HashSet<>();

        //Query ProductID by MinPoint & MaxPoint
        if(StringUtils.isNotEmpty(minPoint) || StringUtils.isNotEmpty(maxPoint)) {
            List<ExProductPoint> exProductPoints = exProductPointService.findByPoint(minPoint,maxPoint);
            Set<String> tmp = exProductPoints.stream().map(ExProductPoint::getProductId).collect(Collectors.toSet());
            if(tmp.size() != 0) productIdSet.addAll(tmp);
            else return null;
        }

        //Query Product by categoryId
        if(StringUtils.isNotEmpty(categoryId)) {
            Set<String> tmp = exProductCategoryMappingService.findByCategoryId(categoryId).stream().map(exProductCategoryMapping -> exProductCategoryMapping.getIdentity().getProductId()).collect(Collectors.toSet());
            if(tmp.size() != 0) productIdSet.addAll(tmp);
            else return null;
        }

        //Query Product by productId
        if(StringUtils.isNotEmpty(productId)) productIdSet.add(productId);

        Pageable pageable = PageRequest.of(pageNo-1, 10);

        Specification specification =  new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicatesList = new ArrayList<Predicate>();

                //add ProductIds
                if(productIdSet.size() != 0) {
                    CriteriaBuilder.In<String> inClause = criteriaBuilder.in(root.get("productId"));
                    productIdSet.forEach(value -> inClause.value(value));
                    predicatesList.add(inClause);
                }

                //add Keyword
                if(StringUtils.isNotEmpty(keyword)) predicatesList.add(criteriaBuilder.like(root.get("productName"),keyword));

                //add Start & End Range
                predicatesList.add(criteriaBuilder.lessThanOrEqualTo(root.get("startTime"), dateService.getTodayStartTime()));
                predicatesList.add(criteriaBuilder.greaterThanOrEqualTo(root.get("endTime"), dateService.getTodayEndTime()));

                Predicate[] predicates = new Predicate[predicatesList.size()];
                return criteriaBuilder.and(predicatesList.toArray(predicates));
            }
        };


        return basicExProduct.findAll(specification, pageable);
    }

    @Transactional
    public int updateStock(int quantity , String productId) {
        Query query = em.createNativeQuery("update ex_product " +
                "set stock_current = stock_current - :quantity " +
                "where product_id = :productId " +
                "and (stock_current - :quantity) > -1");

        query.setParameter("quantity", quantity);
        query.setParameter("productId", productId);

        return query.executeUpdate();
    }
}
