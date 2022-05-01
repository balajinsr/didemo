package com.test.poc.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.test.poc.dao.ImageDAO;
import com.test.poc.entity.ImageEntity;

@Repository
public class ImageDAOImpl implements ImageDAO {
   @PersistenceContext
   private EntityManager em;
   
   @Transactional
   @Override
   public boolean saveTODB(ImageEntity imageEntity) {
      em.persist(imageEntity);
      em.flush();
      return true;
   }

   @Transactional
   @Override
   public ImageEntity findByTagId(String tagId) {
      ImageEntity imageEntity = em.find(ImageEntity.class, tagId);
      return imageEntity;
   }
}
