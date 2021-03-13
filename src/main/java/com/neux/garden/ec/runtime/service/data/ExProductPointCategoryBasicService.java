
/*
* <p> Source File Name: ExProductPointCategoryBasicService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.ExProductPointCategory;
    

import com.neux.garden.ec.runtime.jpa.repository.ExProductPointCategoryRepository;

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
public class ExProductPointCategoryBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(ExProductPointCategoryBasicService.class);

    @Autowired
    protected ExProductPointCategoryRepository basicExProductPointCategory;

    public ExProductPointCategory findByID(String id) {
        return this.basicExProductPointCategory.findById(id).orElse(null);
    }

    public ExProductPointCategory save(ExProductPointCategory exProductPointCategory) {
        return this.basicExProductPointCategory.save(exProductPointCategory);
    }

    public void deleteByID(String id) {
        this.basicExProductPointCategory.deleteById(id);
    }

    public List<ExProductPointCategory> findAll() {
        return this.basicExProductPointCategory.findAll();
    }

    public Page<ExProductPointCategory> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<ExProductPointCategory> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicExProductPointCategory.findAll(pageable);
    }

    public List<ExProductPointCategory> findByOrders(String... order) {
        return this.basicExProductPointCategory.findAll(Sort.by(order));
    }

    public List<ExProductPointCategory> findByOrdersByDesc(String... order) {
        return this.basicExProductPointCategory.findAll(Sort.by(order).descending());
    }

    public Page<ExProductPointCategory> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductPointCategory> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductPointCategory> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<ExProductPointCategory> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<ExProductPointCategory> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicExProductPointCategory.findAll(pageable);
    }
}
