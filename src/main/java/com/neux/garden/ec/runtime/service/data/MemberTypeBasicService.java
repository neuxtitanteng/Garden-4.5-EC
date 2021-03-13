
/*
* <p> Source File Name: MemberTypeBasicService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.MemberType;
    

import com.neux.garden.ec.runtime.jpa.repository.MemberTypeRepository;

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
public class MemberTypeBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(MemberTypeBasicService.class);

    @Autowired
    protected MemberTypeRepository basicMemberType;

    public MemberType findByID(String id) {
        return this.basicMemberType.findById(id).orElse(null);
    }

    public MemberType save(MemberType memberType) {
        return this.basicMemberType.save(memberType);
    }

    public void deleteByID(String id) {
        this.basicMemberType.deleteById(id);
    }

    public List<MemberType> findAll() {
        return this.basicMemberType.findAll();
    }

    public Page<MemberType> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<MemberType> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicMemberType.findAll(pageable);
    }

    public List<MemberType> findByOrders(String... order) {
        return this.basicMemberType.findAll(Sort.by(order));
    }

    public List<MemberType> findByOrdersByDesc(String... order) {
        return this.basicMemberType.findAll(Sort.by(order).descending());
    }

    public Page<MemberType> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<MemberType> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<MemberType> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<MemberType> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<MemberType> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicMemberType.findAll(pageable);
    }
}
