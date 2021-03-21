
/*
* <p> Source File Name: ExProductShoppingCarRepository.java </p>
* <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.jpa.repository;

import com.neux.garden.ec.runtime.jpa.model.ExProduct;
import com.neux.garden.ec.runtime.jpa.model.ExProductShoppingCar;


import com.neux.garden.ec.runtime.jpa.model.ExProductShoppingCarIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ExProductShoppingCarRepository extends JpaRepository<ExProductShoppingCar, ExProductShoppingCarIdentity> {

    @Query("select a from ExProduct a , ExProductShoppingCar b " +
            "where 1=1 " +
            "and a.productId = b.identity.productId " +
            "and b.identity.account = :account " +
            "and a.startTime <= :startTime " +
            "and a.endTime >= :endTime")
    public List<ExProduct> listShoppingCart(@Param("account") String account , @Param("startTime") Date startTime , @Param("endTime") Date endTime);
}
