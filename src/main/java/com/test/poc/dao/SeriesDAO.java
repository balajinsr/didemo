package com.test.poc.dao;

import com.test.poc.entity.SeriesEntity;

public interface SeriesDAO {
   public boolean saveTODB(SeriesEntity seriesEntity);
   public SeriesEntity findByTagId(String tagId);
}
