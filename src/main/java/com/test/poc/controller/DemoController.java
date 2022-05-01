/**
 * 
 */
package com.test.poc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.poc.model.ResponseData;
import com.test.poc.service.DemoService;

@RestController
@RequestMapping(path = "/poc", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoController {
   private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

   @Autowired
   private DemoService demoService;

   @RequestMapping(method = RequestMethod.POST, value = "/saveDicom")
   @ResponseBody
   public Object saveDicom(@RequestBody String jsonData) {
      logger.info("Request API payload: "+jsonData);
      boolean isSaved = demoService.saveToDB(jsonData);
      if(isSaved) {
         logger.info("/saveDicom is successful");
         return ResponseEntity.accepted().build();
      }
      logger.info("/saveDicom is failed");
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
   }
   
   @RequestMapping(method = RequestMethod.GET, value = "/fetchDIComByTagId")
   @ResponseBody
   public Object fetchDIComByTagId(@RequestParam("tagId") String tagId) {
      logger.info("TagId: "+tagId);
      ResponseData responseData = demoService.fetchDIComByTagId(tagId);
     try {
         return ResponseEntity.ok(responseData);
     } catch(Exception e) {
        logger.info("/fetchDIComByTagId is failed");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     }
   }

}
