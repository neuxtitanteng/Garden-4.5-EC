
/*
* <p> Source File Name: MemberBasicService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.Member;
    

import com.neux.garden.ec.runtime.jpa.repository.MemberRepository;

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
public class MemberBasicService {

    protected int pageSize = 10;

    private Logger logger = LoggerFactory.getLogger(MemberBasicService.class);

    @Autowired
    protected MemberRepository basicMember;

    public Member findByID(String id) {
        return this.basicMember.findById(id).orElse(null);
    }

    public Member save(Member member) {
        return this.basicMember.save(member);
    }

    public void deleteByID(String id) {
        this.basicMember.deleteById(id);
    }

    public List<Member> findAll() {
        return this.basicMember.findAll();
    }

    public Page<Member> findByPagination(int pageNo) {
        return findByPagination(pageNo, pageSize);
    }

    public Page<Member> findByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.basicMember.findAll(pageable);
    }

    public List<Member> findByOrders(String... order) {
        return this.basicMember.findAll(Sort.by(order));
    }

    public List<Member> findByOrdersByDesc(String... order) {
        return this.basicMember.findAll(Sort.by(order).descending());
    }

    public Page<Member> findByOrdersAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<Member> findByOrdersAndPagination(int pageNo, int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,false,order);
    }

    public Page<Member> findByOrdersByDescAndPagination(int pageNo ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    public Page<Member> findByOrdersByDescAndPagination(int pageNo , int pageSize ,String... order) {
        return findByOrdersAndPagination(pageNo,pageSize,true,order);
    }

    private Page<Member> findByOrdersAndPagination(int pageNo ,int pageSize, boolean isDesc,String... order) {
        Sort sort = isDesc ? Sort.by(order).descending() : Sort.by(order);
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,sort);

        return this.basicMember.findAll(pageable);
    }
}
