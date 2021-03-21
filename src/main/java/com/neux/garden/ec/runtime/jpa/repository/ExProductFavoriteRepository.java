
/*
* <p> Source File Name: ExProductFavoriteRepository.java </p>
* <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.jpa.repository;

import com.neux.garden.ec.runtime.jpa.model.ExProduct;
import com.neux.garden.ec.runtime.jpa.model.ExProductFavorite;


import com.neux.garden.ec.runtime.jpa.model.ExProductFavoriteIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ExProductFavoriteRepository extends JpaRepository<ExProductFavorite, ExProductFavoriteIdentity> {

    @Query("select a from ExProduct a , ExProductFavorite b " +
            "where 1=1 " +
            "and a.productId = b.identity.productId " +
            "and b.identity.account = :account " +
            "and a.startTime <= :startTime " +
            "and a.endTime >= :endTime")
    public List<ExProduct> listMyFavorite(@Param("account") String account , @Param("startTime") Date startTime , @Param("endTime") Date endTime);
}
