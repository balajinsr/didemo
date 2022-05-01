
package com.test.poc.service;

import com.test.poc.model.ResponseData;

public interface DemoService {
   boolean saveToDB(String jsonData);
   ResponseData fetchDIComByTagId(String categoryName);
}
