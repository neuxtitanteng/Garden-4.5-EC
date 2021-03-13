
/*
* <p> Source File Name: ExProductPointCategoryRepository.java </p>
* <p> Modify Date: Sat Mar 13 11:54:01 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.jpa.repository;

import com.neux.garden.ec.runtime.jpa.model.ExProductPointCategory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ExProductPointCategoryRepository extends JpaRepository<ExProductPointCategory, String> {

}
