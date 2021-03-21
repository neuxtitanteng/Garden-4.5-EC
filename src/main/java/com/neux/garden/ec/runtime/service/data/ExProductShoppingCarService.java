
/*
* <p> Source File Name: ExProductShoppingCarService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.ExProduct;
import com.neux.garden.ec.runtime.service.DateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExProductShoppingCarService extends ExProductShoppingCarBasicService {

    private Logger logger = LoggerFactory.getLogger(ExProductShoppingCarService.class);

    @Autowired
    private DateService dateService;

    public List<ExProduct> listMyShoppingCart(String account) {
        return basicExProductShoppingCar.listShoppingCart(account,dateService.getTodayStartTime(),dateService.getTodayEndTime());
    }
}
