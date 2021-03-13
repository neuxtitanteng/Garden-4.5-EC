
/*
* <p> Source File Name: ExProductPointBasicService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.ExProductPoint;
    

import com.neux.garden.ec.runtime.jpa.repository.ExProductPointRepository;

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
public class ExProductPointBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(ExProductPointBasicService.class);

    @Autowired
    protected ExProductPointRepository basicExProductPoint;

    public ExProductPoint findByID(String id) {
        return this.basicExProductPoint.findById(id).orElse(null);
    }

    public ExProductPoint save(ExProductPoint exProductPoint) {
        return this.basicExProductPoint.save(exProductPoint);
    }

    public void deleteByID(String id) {
        this.basicExProductPoint.deleteById(id);
    }

    public List<ExProductPoint> findAll() {
        return this.basicExProductPoint.findAll();
    }

    public Page<ExProductPoint> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<ExProductPoint> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicExProductPoint.findAll(pageable);
    }

    public List<ExProductPoint> findByOrders(String... order) {
        return this.basicExProductPoint.findAll(Sort.by(order));
    }

    public List<ExProductPoint> findByOrdersByDesc(String... order) {
        return this.basicExProductPoint.findAll(Sort.by(order).descending());
    }

    public Page<ExProductPoint> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductPoint> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductPoint> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<ExProductPoint> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<ExProductPoint> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicExProductPoint.findAll(pageable);
    }
}
