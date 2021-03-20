
/*
* <p> Source File Name: ExProductLogRepository.java </p>
* <p> Modify Date: Sat Mar 20 16:13:38 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.jpa.repository;


import com.neux.garden.ec.runtime.jpa.model.ExProductLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ExProductLogRepository extends JpaRepository<ExProductLog, String> {

}
