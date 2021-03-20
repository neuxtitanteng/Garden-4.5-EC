
/*
* <p> Source File Name: ExProductPointOverviewBasicService.java </p>
* <p> Modify Date: Sat Mar 20 16:40:03 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.ExProductPointOverview;
import com.neux.garden.ec.runtime.jpa.model.ExProductPointOverviewIdentity;
import com.neux.garden.ec.runtime.jpa.repository.ExProductPointOverviewRepository;
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
public class ExProductPointOverviewBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(ExProductPointOverviewBasicService.class);

    @Autowired
    protected ExProductPointOverviewRepository basicExProductPointOverview;

    public ExProductPointOverview findByID(ExProductPointOverviewIdentity id) {
        return this.basicExProductPointOverview.findById(id).orElse(null);
    }

    public ExProductPointOverview save(ExProductPointOverview exProductPointOverview) {
        return this.basicExProductPointOverview.save(exProductPointOverview);
    }

    public void deleteByID(ExProductPointOverviewIdentity id) {
        this.basicExProductPointOverview.deleteById(id);
    }

    public List<ExProductPointOverview> findAll() {
        return this.basicExProductPointOverview.findAll();
    }

    public Page<ExProductPointOverview> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<ExProductPointOverview> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicExProductPointOverview.findAll(pageable);
    }

    public List<ExProductPointOverview> findByOrders(String... order) {
        return this.basicExProductPointOverview.findAll(Sort.by(order));
    }

    public List<ExProductPointOverview> findByOrdersByDesc(String... order) {
        return this.basicExProductPointOverview.findAll(Sort.by(order).descending());
    }

    public Page<ExProductPointOverview> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductPointOverview> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductPointOverview> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<ExProductPointOverview> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<ExProductPointOverview> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicExProductPointOverview.findAll(pageable);
    }
}
