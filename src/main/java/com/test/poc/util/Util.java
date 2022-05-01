package com.test.poc.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {
   private static Map<String, String> map = new HashMap<String, String>();

   public static void initCategories() {
      map.put("00080018", "Image");
      map.put("00200032", "Image");
      map.put("00080021", "Series");
      map.put("0020000E", "Series");
      map.put("00080005", "Study");
      map.put("00080008", "Study");
      map.put("00080020", "Study");
      map.put("0020000D", "Study");
   }

   public static String getCategoryByTagId(String key) {
      if(map.get(key) != null) {
         return map.get(key);
      } else {
         return "";
      }
   }

   private static final ObjectMapper objectMapper = new ObjectMapper();

   public static Map<String, Object> jsonToMap(String s) {
      Map<String, Object> map1 = new HashMap<String, Object>();
      try {
         TypeReference<HashMap<String, Object>> tyypeRef = new TypeReference<HashMap<String, Object>>() {
         };
         map1 = objectMapper.readValue(s, tyypeRef);
         System.out.println(map1);
      } catch (Exception e) {
         e.printStackTrace();
      }

      return map1;

   }

   static {
      initCategories();
   }
}
