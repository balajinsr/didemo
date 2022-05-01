package com.test.poc.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.test.poc.dao.StudyDAO;
import com.test.poc.entity.StudyEntity;

@Repository
public class StudyDAOImpl implements StudyDAO {
   @PersistenceContext
   private EntityManager em;
   
   @Transactional
   @Override
   public boolean saveTODB(StudyEntity studyEntity) {
      em.persist(studyEntity);
      em.flush();
      return true;
   }

   @Transactional
   @Override
   public StudyEntity findByTagId(String tagId) {
      StudyEntity studyEntity = em.find(StudyEntity.class, tagId);
      em.flush();
      return studyEntity;
   }
}
