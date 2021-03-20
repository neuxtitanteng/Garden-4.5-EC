
/*
* <p> Source File Name: ExProductCategoryMappingRepository.java </p>
* <p> Modify Date: Sat Mar 20 15:19:45 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.jpa.repository;



import com.neux.garden.ec.runtime.jpa.model.ExProductCategoryMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ExProductCategoryMappingRepository extends JpaRepository<ExProductCategoryMapping, String> {
    public List<ExProductCategoryMapping> findByIdentityCategoryId(@Param("categoryId") String categoryId);
}
