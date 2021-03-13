
/*
* <p> Source File Name: MgmActivePromoCodeBasicService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.MgmActivePromoCode;
    

import com.neux.garden.ec.runtime.jpa.repository.MgmActivePromoCodeRepository;

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
public class MgmActivePromoCodeBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(MgmActivePromoCodeBasicService.class);

    @Autowired
    protected MgmActivePromoCodeRepository basicMgmActivePromoCode;

    public MgmActivePromoCode findByID(String id) {
        return this.basicMgmActivePromoCode.findById(id).orElse(null);
    }

    public MgmActivePromoCode save(MgmActivePromoCode mgmActivePromoCode) {
        return this.basicMgmActivePromoCode.save(mgmActivePromoCode);
    }

    public void deleteByID(String id) {
        this.basicMgmActivePromoCode.deleteById(id);
    }

    public List<MgmActivePromoCode> findAll() {
        return this.basicMgmActivePromoCode.findAll();
    }

    public Page<MgmActivePromoCode> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<MgmActivePromoCode> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicMgmActivePromoCode.findAll(pageable);
    }

    public List<MgmActivePromoCode> findByOrders(String... order) {
        return this.basicMgmActivePromoCode.findAll(Sort.by(order));
    }

    public List<MgmActivePromoCode> findByOrdersByDesc(String... order) {
        return this.basicMgmActivePromoCode.findAll(Sort.by(order).descending());
    }

    public Page<MgmActivePromoCode> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<MgmActivePromoCode> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<MgmActivePromoCode> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<MgmActivePromoCode> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<MgmActivePromoCode> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicMgmActivePromoCode.findAll(pageable);
    }
}
