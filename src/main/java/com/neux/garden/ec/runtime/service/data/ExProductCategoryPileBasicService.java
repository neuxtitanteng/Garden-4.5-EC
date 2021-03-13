
/*
* <p> Source File Name: ExProductCategoryPileBasicService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.ExProductCategoryPile;
    

import com.neux.garden.ec.runtime.jpa.repository.ExProductCategoryPileRepository;

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
public class ExProductCategoryPileBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(ExProductCategoryPileBasicService.class);

    @Autowired
    protected ExProductCategoryPileRepository basicExProductCategoryPile;

    public ExProductCategoryPile findByID(String id) {
        return this.basicExProductCategoryPile.findById(id).orElse(null);
    }

    public ExProductCategoryPile save(ExProductCategoryPile exProductCategoryPile) {
        return this.basicExProductCategoryPile.save(exProductCategoryPile);
    }

    public void deleteByID(String id) {
        this.basicExProductCategoryPile.deleteById(id);
    }

    public List<ExProductCategoryPile> findAll() {
        return this.basicExProductCategoryPile.findAll();
    }

    public Page<ExProductCategoryPile> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<ExProductCategoryPile> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicExProductCategoryPile.findAll(pageable);
    }

    public List<ExProductCategoryPile> findByOrders(String... order) {
        return this.basicExProductCategoryPile.findAll(Sort.by(order));
    }

    public List<ExProductCategoryPile> findByOrdersByDesc(String... order) {
        return this.basicExProductCategoryPile.findAll(Sort.by(order).descending());
    }

    public Page<ExProductCategoryPile> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductCategoryPile> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductCategoryPile> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<ExProductCategoryPile> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<ExProductCategoryPile> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicExProductCategoryPile.findAll(pageable);
    }
}
