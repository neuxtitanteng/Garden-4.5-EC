
/*
* <p> Source File Name: ExProductBasicService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.ExProduct;
    

import com.neux.garden.ec.runtime.jpa.repository.ExProductRepository;

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
public class ExProductBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(ExProductBasicService.class);

    @Autowired
    protected ExProductRepository basicExProduct;

    public ExProduct findByID(String id) {
        return this.basicExProduct.findById(id).orElse(null);
    }

    public ExProduct save(ExProduct exProduct) {
        return this.basicExProduct.save(exProduct);
    }

    public void deleteByID(String id) {
        this.basicExProduct.deleteById(id);
    }

    public List<ExProduct> findAll() {
        return this.basicExProduct.findAll();
    }

    public Page<ExProduct> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<ExProduct> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicExProduct.findAll(pageable);
    }

    public List<ExProduct> findByOrders(String... order) {
        return this.basicExProduct.findAll(Sort.by(order));
    }

    public List<ExProduct> findByOrdersByDesc(String... order) {
        return this.basicExProduct.findAll(Sort.by(order).descending());
    }

    public Page<ExProduct> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProduct> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProduct> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<ExProduct> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<ExProduct> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicExProduct.findAll(pageable);
    }
}
