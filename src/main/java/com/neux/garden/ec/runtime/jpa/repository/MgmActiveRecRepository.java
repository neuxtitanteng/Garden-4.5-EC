
/*
* <p> Source File Name: MgmActiveRecRepository.java </p>
* <p> Modify Date: Sat Mar 13 11:54:02 CST 2021 </p>
*/

package com.neux.garden.ec.runtime.jpa.repository;

import com.neux.garden.ec.runtime.jpa.model.MgmActiveRec;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MgmActiveRecRepository extends JpaRepository<MgmActiveRec, String> {

}
