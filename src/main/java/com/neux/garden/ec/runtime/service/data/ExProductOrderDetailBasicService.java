
/*
* <p> Source File Name: ExProductOrderDetailBasicService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.ExProductOrderDetail;
    

import com.neux.garden.ec.runtime.jpa.repository.ExProductOrderDetailRepository;

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
public class ExProductOrderDetailBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(ExProductOrderDetailBasicService.class);

    @Autowired
    protected ExProductOrderDetailRepository basicExProductOrderDetail;

    public ExProductOrderDetail findByID(String id) {
        return this.basicExProductOrderDetail.findById(id).orElse(null);
    }

    public ExProductOrderDetail save(ExProductOrderDetail exProductOrderDetail) {
        return this.basicExProductOrderDetail.save(exProductOrderDetail);
    }

    public void deleteByID(String id) {
        this.basicExProductOrderDetail.deleteById(id);
    }

    public List<ExProductOrderDetail> findAll() {
        return this.basicExProductOrderDetail.findAll();
    }

    public Page<ExProductOrderDetail> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<ExProductOrderDetail> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicExProductOrderDetail.findAll(pageable);
    }

    public List<ExProductOrderDetail> findByOrders(String... order) {
        return this.basicExProductOrderDetail.findAll(Sort.by(order));
    }

    public List<ExProductOrderDetail> findByOrdersByDesc(String... order) {
        return this.basicExProductOrderDetail.findAll(Sort.by(order).descending());
    }

    public Page<ExProductOrderDetail> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductOrderDetail> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductOrderDetail> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<ExProductOrderDetail> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<ExProductOrderDetail> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicExProductOrderDetail.findAll(pageable);
    }
}
