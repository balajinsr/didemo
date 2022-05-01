package com.test.poc.dao;

import com.test.poc.entity.ImageEntity;

public interface ImageDAO   {
   public boolean saveTODB(ImageEntity imageEntity);
   public ImageEntity findByTagId(String tagId);
   
}
