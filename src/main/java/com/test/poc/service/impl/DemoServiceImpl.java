package com.test.poc.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.poc.dao.ImageDAO;
import com.test.poc.dao.SeriesDAO;
import com.test.poc.dao.StudyDAO;
import com.test.poc.entity.ImageEntity;
import com.test.poc.entity.SeriesEntity;
import com.test.poc.entity.StudyEntity;
import com.test.poc.model.ResponseData;
import com.test.poc.service.DemoService;
import com.test.poc.util.Util;

@Service
public class DemoServiceImpl implements DemoService {
   private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

   @Autowired
   private SeriesDAO serialDAO;

   @Autowired
   private ImageDAO imageDAO;

   @Autowired
   private StudyDAO studyDAO;

   @SuppressWarnings("rawtypes")
   @Override
   public boolean saveToDB(String jsonData) {
      Map<String, Object> map = Util.jsonToMap(jsonData);
      try {
         Iterator<String> it = map.keySet().iterator();
         while (it.hasNext()) {
            String tagId = it.next();
            Object value = map.get(tagId);

            System.out.println("tagId:" + tagId);
            Map valueMap = ((LinkedHashMap<String, ArrayList<String>>) value);
            System.out.println("vr:" + valueMap.get("vr"));
            System.out.println("value:" + ((ArrayList) valueMap.get("Value")).get(0));
            String categoryName = Util.getCategoryByTagId(tagId);
            System.out.println("Category: " + categoryName);

            switch (categoryName) {
               case "Series": {
                  SeriesEntity seriesEntity = new SeriesEntity();
                  seriesEntity.setTagId(tagId);
                  seriesEntity.setVr((String) valueMap.get("vr"));
                  seriesEntity.setValue(((ArrayList) valueMap.get("Value")).toString());
                  serialDAO.saveTODB(seriesEntity);
                  break;
               }
               case "Study": {
                  StudyEntity studyEntity = new StudyEntity();
                  studyEntity.setTagId(tagId);
                  studyEntity.setVr((String) valueMap.get("vr"));
                  studyEntity.setValue(((ArrayList) valueMap.get("Value")).toString());
                  studyDAO.saveTODB(studyEntity);
                  break;
               }
               case "Image": {
                  ImageEntity imageEntity = new ImageEntity();
                  imageEntity.setTagId(tagId);
                  imageEntity.setVr((String) valueMap.get("vr"));
                  imageEntity.setValue(((ArrayList) valueMap.get("Value")).toString());
                  imageDAO.saveTODB(imageEntity);
                  break;
               }
               default: {
                  StudyEntity studyEntity = new StudyEntity();
                  studyEntity.setTagId(tagId);
                  studyEntity.setVr((String) valueMap.get("vr"));
                  studyEntity.setValue(((ArrayList) valueMap.get("Value")).toString());
                  return studyDAO.saveTODB(studyEntity);

               }
            }
         }
      } catch (Exception e) {
         logger.error("Exception: " + e, e);
         return false;
      }

      return true;

   }

   @Override
   public ResponseData fetchDIComByTagId(String tagId) {
      ResponseData responseData = new ResponseData();
      String categoryName = Util.getCategoryByTagId(tagId);
      switch (categoryName) {
         case "Image": {
            ImageEntity entity = imageDAO.findByTagId(tagId);
            BeanUtils.copyProperties(entity, responseData);
            return responseData;
         }
         case "Series": {
            SeriesEntity entity = serialDAO.findByTagId(tagId);
            BeanUtils.copyProperties(entity, responseData);
            return responseData;
         }
         case "Study": {
            StudyEntity entity = studyDAO.findByTagId(tagId);
            BeanUtils.copyProperties(entity, responseData);
            return responseData;
         }
         default: {
            return responseData;
         }
      }
   }
}
