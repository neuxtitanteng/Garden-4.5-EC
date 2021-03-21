
/*
* <p> Source File Name: ExProductFavoriteService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
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
public class ExProductFavoriteService extends ExProductFavoriteBasicService {

    private Logger logger = LoggerFactory.getLogger(ExProductFavoriteService.class);

    @Autowired
    private DateService dateService;

    public List<ExProduct> listMyFavorite(String account) {
        return basicExProductFavorite.listMyFavorite(account,dateService.getTodayStartTime(),dateService.getTodayEndTime());
    }
}
