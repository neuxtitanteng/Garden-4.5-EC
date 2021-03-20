
/*
* <p> Source File Name: ExProductPointService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.ExProductPoint;
import com.neux.garden.ec.runtime.service.DateService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExProductPointService<T> extends ExProductPointBasicService {

    private Logger logger = LoggerFactory.getLogger(ExProductPointService.class);

    @Autowired
    private DateService dateService;

    public List<ExProductPoint> findByPoint(String minPoint , String maxPoint) {

        logger.trace("findByPoint , minPoint={} , maxPoint={}",minPoint,maxPoint);

        Specification specification = (Specification<T>) (root, query, criteriaBuilder) -> {

            List<Predicate> predicatesList = new ArrayList<Predicate>();

            if(StringUtils.isNotEmpty(maxPoint)) predicatesList.add(criteriaBuilder.greaterThanOrEqualTo(root.get("point"),maxPoint));
            if(StringUtils.isNotEmpty(minPoint)) predicatesList.add(criteriaBuilder.lessThanOrEqualTo(root.get("point"),minPoint));

            predicatesList.add(criteriaBuilder.lessThanOrEqualTo(root.get("startTime"),dateService.getTodayStartTime()));
            predicatesList.add(criteriaBuilder.greaterThanOrEqualTo(root.get("endTime"),dateService.getTodayEndTime()));

            Predicate[] predicates = new Predicate[predicatesList.size()];
            return criteriaBuilder.and(predicatesList.toArray(predicates));
        };

        return basicExProductPoint.findAll(specification);
    }


}
