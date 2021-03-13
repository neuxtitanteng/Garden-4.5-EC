
/*
* <p> Source File Name: ExProductCategoryBasicService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.ExProductCategory;
    

import com.neux.garden.ec.runtime.jpa.repository.ExProductCategoryRepository;

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
public class ExProductCategoryBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(ExProductCategoryBasicService.class);

    @Autowired
    protected ExProductCategoryRepository basicExProductCategory;

    public ExProductCategory findByID(String id) {
        return this.basicExProductCategory.findById(id).orElse(null);
    }

    public ExProductCategory save(ExProductCategory exProductCategory) {
        return this.basicExProductCategory.save(exProductCategory);
    }

    public void deleteByID(String id) {
        this.basicExProductCategory.deleteById(id);
    }

    public List<ExProductCategory> findAll() {
        return this.basicExProductCategory.findAll();
    }

    public Page<ExProductCategory> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<ExProductCategory> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicExProductCategory.findAll(pageable);
    }

    public List<ExProductCategory> findByOrders(String... order) {
        return this.basicExProductCategory.findAll(Sort.by(order));
    }

    public List<ExProductCategory> findByOrdersByDesc(String... order) {
        return this.basicExProductCategory.findAll(Sort.by(order).descending());
    }

    public Page<ExProductCategory> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductCategory> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductCategory> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<ExProductCategory> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<ExProductCategory> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicExProductCategory.findAll(pageable);
    }
}
