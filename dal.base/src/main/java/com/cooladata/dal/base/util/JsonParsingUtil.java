package com.cooladata.dal.base.util;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParsingUtil {

	public final static ObjectMapper mapper = new ObjectMapper();
	
	public static String convertObjectToString(Object object) throws JsonProcessingException
	{
		String json = mapper.writeValueAsString(object);
		return json;
	}
	
	public static Map<String,Object> convertObjectToMap(Object object) throws IOException
	{
		String json = mapper.writeValueAsString(object);
		return convertJsonToMap(json);
	}
	
	public static Map<String,Object> convertJsonToMap(String json) throws JsonParseException, JsonMappingException, IOException
	{
		Map<String,Object> map = mapper.readValue(json, HashMap.class);
		return map;
	}
	
	public static <T> T convertJsonToObject(String json,Class<T> objectClass) throws JsonParseException, JsonMappingException, IOException
	{
		T t =  mapper.readValue(json,objectClass );
		return t;
	}
	
	public static <T> T convertMapToObject(Map<String,Object> values,Class<T> objectClass) throws IOException
	{
		String jsonString = JsonParsingUtil.convertObjectToString(values);
		
		return JsonParsingUtil.convertJsonToObject(jsonString, objectClass);
		
	}
	
	public static String convertMapToString(Map<String,Object> map)
	{
		 StringBuilder sb = new StringBuilder();
		 sb.append("{");
		 Iterator it = map.entrySet().iterator();
	     while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        sb.append("\""+pairs.getKey()+"\"" + ":"+ "\""+pairs.getValue()+"\"");
	        //System.out.println(pairs.getKey() + " = " + pairs.getValue());
	        it.remove(); // avoids a ConcurrentModificationException;
	        if(it.hasNext())
	        	sb.append(",");
	        
	     }
	     sb.append("}");
	     return sb.toString();
	}
	
	public static Map<String, Date> convertJsonToMapOfDates(String json) throws JsonParseException, JsonMappingException, IOException {
		Map<String, Date> map = mapper.readValue(json, new TypeReference<HashMap<String, Date>>() {});
		return map;
	}
}
