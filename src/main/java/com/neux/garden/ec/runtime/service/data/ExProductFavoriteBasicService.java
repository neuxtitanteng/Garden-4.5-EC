
/*
* <p> Source File Name: ExProductFavoriteBasicService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.ExProductFavorite;


import com.neux.garden.ec.runtime.jpa.model.ExProductFavoriteIdentity;
import com.neux.garden.ec.runtime.jpa.repository.ExProductFavoriteRepository;

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
public class ExProductFavoriteBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(ExProductFavoriteBasicService.class);

    @Autowired
    protected ExProductFavoriteRepository basicExProductFavorite;

    public ExProductFavorite findByID(ExProductFavoriteIdentity id) {
        return this.basicExProductFavorite.findById(id).orElse(null);
    }

    public ExProductFavorite save(ExProductFavorite exProductFavorite) {
        return this.basicExProductFavorite.save(exProductFavorite);
    }

    public void deleteByID(ExProductFavoriteIdentity id) {
        this.basicExProductFavorite.deleteById(id);
    }

    public List<ExProductFavorite> findAll() {
        return this.basicExProductFavorite.findAll();
    }

    public Page<ExProductFavorite> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<ExProductFavorite> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicExProductFavorite.findAll(pageable);
    }

    public List<ExProductFavorite> findByOrders(String... order) {
        return this.basicExProductFavorite.findAll(Sort.by(order));
    }

    public List<ExProductFavorite> findByOrdersByDesc(String... order) {
        return this.basicExProductFavorite.findAll(Sort.by(order).descending());
    }

    public Page<ExProductFavorite> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductFavorite> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductFavorite> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<ExProductFavorite> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<ExProductFavorite> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicExProductFavorite.findAll(pageable);
    }
}
