
/*
* <p> Source File Name: MgmActiveRecBasicService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.MgmActiveRec;
    

import com.neux.garden.ec.runtime.jpa.repository.MgmActiveRecRepository;

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
public class MgmActiveRecBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(MgmActiveRecBasicService.class);

    @Autowired
    protected MgmActiveRecRepository basicMgmActiveRec;

    public MgmActiveRec findByID(String id) {
        return this.basicMgmActiveRec.findById(id).orElse(null);
    }

    public MgmActiveRec save(MgmActiveRec mgmActiveRec) {
        return this.basicMgmActiveRec.save(mgmActiveRec);
    }

    public void deleteByID(String id) {
        this.basicMgmActiveRec.deleteById(id);
    }

    public List<MgmActiveRec> findAll() {
        return this.basicMgmActiveRec.findAll();
    }

    public Page<MgmActiveRec> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<MgmActiveRec> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicMgmActiveRec.findAll(pageable);
    }

    public List<MgmActiveRec> findByOrders(String... order) {
        return this.basicMgmActiveRec.findAll(Sort.by(order));
    }

    public List<MgmActiveRec> findByOrdersByDesc(String... order) {
        return this.basicMgmActiveRec.findAll(Sort.by(order).descending());
    }

    public Page<MgmActiveRec> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<MgmActiveRec> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<MgmActiveRec> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<MgmActiveRec> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<MgmActiveRec> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicMgmActiveRec.findAll(pageable);
    }
}
