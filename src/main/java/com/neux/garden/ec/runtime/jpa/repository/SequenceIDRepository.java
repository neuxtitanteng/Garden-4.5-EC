package com.neux.garden.ec.runtime.jpa.repository;

import com.neux.garden.cms.service.bean.CMSSequence;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigInteger;

@Repository
public class SequenceIDRepository {

    @PersistenceContext
    private EntityManager em;  // 注入实体管理器

    public BigInteger getSequenceID(CMSSequence sequence) {
        return getSequenceID(sequence.getSequence());
    }

    public BigInteger getSequenceID(String sequenceName) {
        //SQL SERVER
        javax.persistence.Query q = em.createNativeQuery("select Next Value for "+sequenceName);
        return (BigInteger)q.getSingleResult();
    }
    
    @Transactional
    public void resetSequenceNumber(CMSSequence sequence) {
    	resetSequenceNumber(sequence.getSequence());
   }
   
    @Transactional
   public void resetSequenceNumber(String sequenceName) {
   	javax.persistence.Query q = em.createNativeQuery("ALTER SEQUENCE "+sequenceName+" RESTART WITH 1");
       q.executeUpdate();
   }


}