
/*
* <p> Source File Name: ExProductOrderDetailService.java </p>
* <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.ExProductOrderDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExProductOrderDetailService extends ExProductOrderDetailBasicService {

    private Logger logger = LoggerFactory.getLogger(ExProductOrderDetailService.class);


    public void saveAll(List<ExProductOrderDetail> detailList) {
        basicExProductOrderDetail.saveAll(detailList);
    }
}
