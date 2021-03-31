
/*
* <p> Source File Name: ExProductOrderService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.ExProduct;
import com.neux.garden.ec.runtime.jpa.model.ExProductOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExProductOrderService extends ExProductOrderBasicService {

    private Logger logger = LoggerFactory.getLogger(ExProductOrderService.class);

    public List<ExProduct> listHistoryProduct(String account) {
        return basicExProductOrder.listHistoryProduct(account);
    }

    public List<ExProductOrder> listHistoryOrder(String account) {
        return basicExProductOrder.listHistoryOrder(account);
    }
}
