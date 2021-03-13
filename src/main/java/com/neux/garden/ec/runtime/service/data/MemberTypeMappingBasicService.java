
/*
* <p> Source File Name: MemberTypeMappingBasicService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.MemberTypeMapping;
    

import com.neux.garden.ec.runtime.jpa.repository.MemberTypeMappingRepository;

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
public class MemberTypeMappingBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(MemberTypeMappingBasicService.class);

    @Autowired
    protected MemberTypeMappingRepository basicMemberTypeMapping;

    public MemberTypeMapping findByID(String id) {
        return this.basicMemberTypeMapping.findById(id).orElse(null);
    }

    public MemberTypeMapping save(MemberTypeMapping memberTypeMapping) {
        return this.basicMemberTypeMapping.save(memberTypeMapping);
    }

    public void deleteByID(String id) {
        this.basicMemberTypeMapping.deleteById(id);
    }

    public List<MemberTypeMapping> findAll() {
        return this.basicMemberTypeMapping.findAll();
    }

    public Page<MemberTypeMapping> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<MemberTypeMapping> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicMemberTypeMapping.findAll(pageable);
    }

    public List<MemberTypeMapping> findByOrders(String... order) {
        return this.basicMemberTypeMapping.findAll(Sort.by(order));
    }

    public List<MemberTypeMapping> findByOrdersByDesc(String... order) {
        return this.basicMemberTypeMapping.findAll(Sort.by(order).descending());
    }

    public Page<MemberTypeMapping> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<MemberTypeMapping> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<MemberTypeMapping> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<MemberTypeMapping> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<MemberTypeMapping> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicMemberTypeMapping.findAll(pageable);
    }
}
