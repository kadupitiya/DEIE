/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.deie.model;

/**
 *
 * @author Kadupitiya
 */
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSON_POJO {
	private static Gson gson = new Gson();
	private static JsonParser parser = new JsonParser();
	public static String pojoToJson(Object obj){
		
		return gson.toJson(obj); 
	}
	
	public static JsonObject pojoToJsonObj(Object obj){
		return (JsonObject)parser.parse(pojoToJson(obj));
	}
	public static <T> Object jsonToPojo(String json,   Class<T> classOfT){
		
		return gson.fromJson(json, classOfT);  
	}
	
	
	
}
