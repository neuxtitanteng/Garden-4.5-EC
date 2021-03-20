
/*
* <p> Source File Name: ExProductCategoryMappingService.java </p>
* <p> Modify Date: Sat Mar 20 15:19:45 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.service.data;

import com.neux.garden.ec.runtime.jpa.model.ExProductCategory;
import com.neux.garden.ec.runtime.jpa.model.ExProductCategoryMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExProductCategoryMappingService extends ExProductCategoryMappingBasicService {

    private Logger logger = LoggerFactory.getLogger(ExProductCategoryMappingService.class);

    public List<ExProductCategoryMapping> findByCategoryId(String categoryId) {
        return basicExProductCategoryMapping.findByIdentityCategoryId(categoryId);
    }
}
