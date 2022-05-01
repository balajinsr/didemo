package com.test.poc.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.test.poc.dao.SeriesDAO;
import com.test.poc.entity.SeriesEntity;

@Repository
public class SeriesDAOImpl implements SeriesDAO {
   @PersistenceContext
   private EntityManager em;
   
   @Transactional
   @Override
   public boolean saveTODB(SeriesEntity seriesEntity) {
      em.persist(seriesEntity);
      em.flush();
      return true;
   }

   @Transactional
   @Override
   public SeriesEntity findByTagId(String tagId) {
      SeriesEntity seriesEntity = em.find(SeriesEntity.class, tagId);
      return seriesEntity;
   }
}
