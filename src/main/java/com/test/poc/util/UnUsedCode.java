package com.test.poc.util;

public class UnUsedCode {
	
	public static void unUsedCode() {
		
		/*
		 * String fileName, file, location; Scanner sc = new Scanner(System.in);
		 * fileName = sc.nextLine(); location = sc.nextLine(); sc.close();
		 */
		
		
		/*
		 * System.out.println(reader); // Read JSON file Object obj = null; try { obj =
		 * jsonParser.parse(reader); DicomApplication d=new DicomApplication();
		 * d.jsonToMap((JSONObject) obj); System.out.println(obj); } catch
		 * (org.json.simple.parser.ParseException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 * 
		 * JSONArray diComList = (JSONArray) obj; System.out.println(diComList);
		 */
		// Iterate over employee array
		// diComList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
		
		
		
		/*
		 * public static Map<String, Object> jsonToMap(JSONObject json) {
		 * System.out.println("jsonToMap()"); Map<String, Object> retMap = new
		 * HashMap<String, Object>();
		 * 
		 * if(json != null) { retMap = toMap(json); System.out.println(retMap); } return
		 * retMap; }
		 */
		/*
		 * public static Map<String, Object> toMap(JSONObject object) { Map<String,
		 * Object> map = new HashMap<String, Object>();
		 * 
		 * Iterable keysItr = object.keySet();
		 * 
		 * Util u=new Util(); Map<String, String> categeryMap= u.categeoryMap(keysItr);
		 * 
		 * while(((Iterator<String>) keysItr).hasNext()) { String key =
		 * ((Iterator<String>) keysItr).next(); Object value = object.get(key);
		 * 
		 * if(value instanceof JSONArray) { value = toList((JSONArray) value); }
		 * 
		 * else if(value instanceof JSONObject) { value = toMap((JSONObject) value); }
		 * map.put(key, value); } return map; }
		 */

	}

}
