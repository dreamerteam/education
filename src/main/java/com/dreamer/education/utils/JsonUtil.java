package com.dreamer.education.utils;

import java.lang.reflect.Type;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {
	private static Logger logger = Logger.getLogger(JsonUtil.class);
	
	private static Gson gson = new GsonBuilder().setPrettyPrinting()
			.setDateFormat("yyyy-MM-dd HH:mm:ss").create();//

	public static String toJson(Object obj) {
		return JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat);
		// return gson.toJson(obj);
	}

	// public static String toJson(Object obj, Type type){
	// return gson.toJson(obj, type);
	// }
	//
	public static <T> T fromJson(String json, Class<T> cla) {
		return gson.fromJson(json, cla);
	}

	
	@SuppressWarnings({ "unchecked", "hiding" })
	public static <Object> Object fromJson(String json, Type type) {
		return (Object)gson.fromJson(json, type);
	}
	
	public static <T> T toJSONObject(String jsonStr,Class<T> type){
		try{
			return JSON.parseObject(jsonStr,type);
		}catch(Exception e){
			logger.error(jsonStr +","+type+" toJSONObject fail"+e.getMessage());
			return null;
		}
		
	}
}
