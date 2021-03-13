
/*
* <p> Source File Name: MgmActiveRecTypeBasicService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.MgmActiveRecType;
    

import com.neux.garden.ec.runtime.jpa.repository.MgmActiveRecTypeRepository;

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
public class MgmActiveRecTypeBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(MgmActiveRecTypeBasicService.class);

    @Autowired
    protected MgmActiveRecTypeRepository basicMgmActiveRecType;

    public MgmActiveRecType findByID(String id) {
        return this.basicMgmActiveRecType.findById(id).orElse(null);
    }

    public MgmActiveRecType save(MgmActiveRecType mgmActiveRecType) {
        return this.basicMgmActiveRecType.save(mgmActiveRecType);
    }

    public void deleteByID(String id) {
        this.basicMgmActiveRecType.deleteById(id);
    }

    public List<MgmActiveRecType> findAll() {
        return this.basicMgmActiveRecType.findAll();
    }

    public Page<MgmActiveRecType> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<MgmActiveRecType> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicMgmActiveRecType.findAll(pageable);
    }

    public List<MgmActiveRecType> findByOrders(String... order) {
        return this.basicMgmActiveRecType.findAll(Sort.by(order));
    }

    public List<MgmActiveRecType> findByOrdersByDesc(String... order) {
        return this.basicMgmActiveRecType.findAll(Sort.by(order).descending());
    }

    public Page<MgmActiveRecType> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<MgmActiveRecType> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<MgmActiveRecType> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<MgmActiveRecType> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<MgmActiveRecType> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicMgmActiveRecType.findAll(pageable);
    }
}
