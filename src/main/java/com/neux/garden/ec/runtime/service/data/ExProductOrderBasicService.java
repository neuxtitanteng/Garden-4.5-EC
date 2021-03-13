
/*
* <p> Source File Name: ExProductOrderBasicService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.ExProductOrder;
    

import com.neux.garden.ec.runtime.jpa.repository.ExProductOrderRepository;

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
public class ExProductOrderBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(ExProductOrderBasicService.class);

    @Autowired
    protected ExProductOrderRepository basicExProductOrder;

    public ExProductOrder findByID(String id) {
        return this.basicExProductOrder.findById(id).orElse(null);
    }

    public ExProductOrder save(ExProductOrder exProductOrder) {
        return this.basicExProductOrder.save(exProductOrder);
    }

    public void deleteByID(String id) {
        this.basicExProductOrder.deleteById(id);
    }

    public List<ExProductOrder> findAll() {
        return this.basicExProductOrder.findAll();
    }

    public Page<ExProductOrder> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<ExProductOrder> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicExProductOrder.findAll(pageable);
    }

    public List<ExProductOrder> findByOrders(String... order) {
        return this.basicExProductOrder.findAll(Sort.by(order));
    }

    public List<ExProductOrder> findByOrdersByDesc(String... order) {
        return this.basicExProductOrder.findAll(Sort.by(order).descending());
    }

    public Page<ExProductOrder> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductOrder> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductOrder> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<ExProductOrder> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<ExProductOrder> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicExProductOrder.findAll(pageable);
    }
}
