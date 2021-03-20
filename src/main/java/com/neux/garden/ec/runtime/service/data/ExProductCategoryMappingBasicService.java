
/*
* <p> Source File Name: ExProductCategoryMappingBasicService.java </p>
* <p> Modify Date: Sat Mar 20 15:19:45 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;



import com.neux.garden.ec.runtime.jpa.model.ExProductCategoryMapping;
import com.neux.garden.ec.runtime.jpa.repository.ExProductCategoryMappingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExProductCategoryMappingBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(ExProductCategoryMappingBasicService.class);

    @Autowired
    protected ExProductCategoryMappingRepository basicExProductCategoryMapping;

    public ExProductCategoryMapping findByID(String id) {
        return this.basicExProductCategoryMapping.findById(id).orElse(null);
    }

    public ExProductCategoryMapping save(ExProductCategoryMapping exProductCategoryMapping) {
        return this.basicExProductCategoryMapping.save(exProductCategoryMapping);
    }

    public void deleteByID(String id) {
        this.basicExProductCategoryMapping.deleteById(id);
    }

    public List<ExProductCategoryMapping> findAll() {
        return this.basicExProductCategoryMapping.findAll();
    }

    public Page<ExProductCategoryMapping> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<ExProductCategoryMapping> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicExProductCategoryMapping.findAll(pageable);
    }

    public List<ExProductCategoryMapping> findByOrders(String... order) {
        return this.basicExProductCategoryMapping.findAll(Sort.by(order));
    }

    public List<ExProductCategoryMapping> findByOrdersByDesc(String... order) {
        return this.basicExProductCategoryMapping.findAll(Sort.by(order).descending());
    }

    public Page<ExProductCategoryMapping> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductCategoryMapping> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductCategoryMapping> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<ExProductCategoryMapping> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<ExProductCategoryMapping> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicExProductCategoryMapping.findAll(pageable);
    }
}
