
/*
* <p> Source File Name: ExProductLogBasicService.java </p>
* <p> Modify Date: Sat Mar 20 16:13:38 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;



import com.neux.garden.ec.runtime.jpa.model.ExProductLog;
import com.neux.garden.ec.runtime.jpa.repository.ExProductLogRepository;
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
public class ExProductLogBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(ExProductLogBasicService.class);

    @Autowired
    protected ExProductLogRepository basicExProductLog;

    public ExProductLog findByID(String id) {
        return this.basicExProductLog.findById(id).orElse(null);
    }

    public ExProductLog save(ExProductLog exProductLog) {
        return this.basicExProductLog.save(exProductLog);
    }

    public void deleteByID(String id) {
        this.basicExProductLog.deleteById(id);
    }

    public List<ExProductLog> findAll() {
        return this.basicExProductLog.findAll();
    }

    public Page<ExProductLog> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<ExProductLog> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicExProductLog.findAll(pageable);
    }

    public List<ExProductLog> findByOrders(String... order) {
        return this.basicExProductLog.findAll(Sort.by(order));
    }

    public List<ExProductLog> findByOrdersByDesc(String... order) {
        return this.basicExProductLog.findAll(Sort.by(order).descending());
    }

    public Page<ExProductLog> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductLog> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductLog> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<ExProductLog> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<ExProductLog> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicExProductLog.findAll(pageable);
    }
}
