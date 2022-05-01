package com.test.poc.dao;

import com.test.poc.entity.StudyEntity;

public interface StudyDAO {
   public boolean saveTODB(StudyEntity studyEntity);
   public StudyEntity findByTagId(String tagId);
}
