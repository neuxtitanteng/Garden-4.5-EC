
/*
* <p> Source File Name: ExProductPointOverviewService.java </p>
* <p> Modify Date: Sat Mar 20 16:40:03 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.ExProductPointOverview;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExProductPointOverviewService extends ExProductPointOverviewBasicService {

    private Logger logger = LoggerFactory.getLogger(ExProductPointOverviewService.class);

    public List<ExProductPointOverview> findByProductId(String productId) {
        return basicExProductPointOverview.findByIdentityProductIdOrderByOrders(productId);
    }

    public ExProductPointOverview findByIdentityProductIdAndIdentityCategoryId(String productId ,String categoryId) {
        return basicExProductPointOverview.findByIdentityProductIdAndIdentityCategoryId(productId,categoryId);
    }

}
