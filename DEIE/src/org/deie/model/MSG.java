/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.deie.model;

/**
 *
 * @author Kadupitiya
 */

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MSG {
	private static JsonObject obj;
	private static JsonParser parser = new JsonParser();
	
	public static String getJSONMSG(String msg) {
		obj = new JsonObject();
		obj.addProperty("msg", msg);
		return obj.toString();
	}

	public static String getJSONStatus(boolean status) {
		obj = new JsonObject();
		obj.addProperty("status", status);
		return obj.toString();
	}

	public static String getJSONStatusMessage(boolean status, String msg) {
		obj = new JsonObject();
		obj.addProperty("status", status);
		obj.addProperty("msg", msg);
		return obj.toString();
	}
	public static String getJSON_DATA_MSG(boolean status, String data) {
		return getJSON_DATA_MSG_OBJ(status, data).toString();
	}
	public static JsonObject getJSON_DATA_MSG_OBJ(boolean status, String data) {
		obj = new JsonObject();
		obj.addProperty("status", status);
		obj.add("data", parser.parse(data));
		return obj;
	}
	
	public static String getJSON_DATA_MSG(boolean status, String data,String data2) {
		return getJSON_DATA_MSG_OBJ(status, data,data2).toString();
	}
	
	public static JsonObject getJSON_DATA_MSG_OBJ(boolean status, String data,String data2) {
		obj = new JsonObject();
		obj.addProperty("status", status);
		obj.add("data", parser.parse(data));
		obj.add("dataTwo", parser.parse(data2));
		return obj;
	}
	
	
	
}
