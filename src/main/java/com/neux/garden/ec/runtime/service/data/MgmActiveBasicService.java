
/*
* <p> Source File Name: MgmActiveBasicService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.MgmActive;
    

import com.neux.garden.ec.runtime.jpa.repository.MgmActiveRepository;

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
public class MgmActiveBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(MgmActiveBasicService.class);

    @Autowired
    protected MgmActiveRepository basicMgmActive;

    public MgmActive findByID(String id) {
        return this.basicMgmActive.findById(id).orElse(null);
    }

    public MgmActive save(MgmActive mgmActive) {
        return this.basicMgmActive.save(mgmActive);
    }

    public void deleteByID(String id) {
        this.basicMgmActive.deleteById(id);
    }

    public List<MgmActive> findAll() {
        return this.basicMgmActive.findAll();
    }

    public Page<MgmActive> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<MgmActive> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicMgmActive.findAll(pageable);
    }

    public List<MgmActive> findByOrders(String... order) {
        return this.basicMgmActive.findAll(Sort.by(order));
    }

    public List<MgmActive> findByOrdersByDesc(String... order) {
        return this.basicMgmActive.findAll(Sort.by(order).descending());
    }

    public Page<MgmActive> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<MgmActive> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<MgmActive> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<MgmActive> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<MgmActive> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicMgmActive.findAll(pageable);
    }
}
