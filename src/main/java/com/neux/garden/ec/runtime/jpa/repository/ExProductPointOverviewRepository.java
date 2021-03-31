
/*
* <p> Source File Name: ExProductPointOverviewRepository.java </p>
* <p> Modify Date: Sat Mar 20 16:40:03 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.jpa.repository;


import com.neux.garden.ec.runtime.jpa.model.ExProductPointOverview;
import com.neux.garden.ec.runtime.jpa.model.ExProductPointOverviewIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ExProductPointOverviewRepository extends JpaRepository<ExProductPointOverview, ExProductPointOverviewIdentity> {

    public List<ExProductPointOverview> findByIdentityProductIdOrderByOrders(@Param("productId") String productId);

    public ExProductPointOverview findByIdentityProductIdAndIdentityCategoryId(@Param("productId") String productId,@Param("categoryId") String categoryId);
}
