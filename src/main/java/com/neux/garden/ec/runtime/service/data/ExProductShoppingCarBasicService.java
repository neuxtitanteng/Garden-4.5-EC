
/*
* <p> Source File Name: ExProductShoppingCarBasicService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.ExProductShoppingCar;
    

import com.neux.garden.ec.runtime.jpa.repository.ExProductShoppingCarRepository;

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
public class ExProductShoppingCarBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(ExProductShoppingCarBasicService.class);

    @Autowired
    protected ExProductShoppingCarRepository basicExProductShoppingCar;

    public ExProductShoppingCar findByID(String id) {
        return this.basicExProductShoppingCar.findById(id).orElse(null);
    }

    public ExProductShoppingCar save(ExProductShoppingCar exProductShoppingCar) {
        return this.basicExProductShoppingCar.save(exProductShoppingCar);
    }

    public void deleteByID(String id) {
        this.basicExProductShoppingCar.deleteById(id);
    }

    public List<ExProductShoppingCar> findAll() {
        return this.basicExProductShoppingCar.findAll();
    }

    public Page<ExProductShoppingCar> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<ExProductShoppingCar> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicExProductShoppingCar.findAll(pageable);
    }

    public List<ExProductShoppingCar> findByOrders(String... order) {
        return this.basicExProductShoppingCar.findAll(Sort.by(order));
    }

    public List<ExProductShoppingCar> findByOrdersByDesc(String... order) {
        return this.basicExProductShoppingCar.findAll(Sort.by(order).descending());
    }

    public Page<ExProductShoppingCar> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductShoppingCar> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<ExProductShoppingCar> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<ExProductShoppingCar> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<ExProductShoppingCar> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicExProductShoppingCar.findAll(pageable);
    }
}
