
/*
* <p> Source File Name: ExProductOrderRepository.java </p>
* <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.jpa.repository;

import com.neux.garden.ec.runtime.jpa.model.ExProduct;
import com.neux.garden.ec.runtime.jpa.model.ExProductOrder;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ExProductOrderRepository extends JpaRepository<ExProductOrder, String> {

    @Query("select c from ExProductOrder a , ExProductOrderDetail b , ExProduct c\n" +
            "where a.orderId = b.identity.orderId\n" +
            "and b.identity.productId = c.productId\n" +
            "and a.account = :account\n" +
            "order by a.orderDate desc")
    public List<ExProduct> listHistoryProduct(@Param("account") String account);

    @Query("select a from ExProductOrder a \n" +
            "where a.account = :account\n" +
            "order by a.orderDate desc")
    public List<ExProductOrder> listHistoryOrder(@Param("account") String account);
}
