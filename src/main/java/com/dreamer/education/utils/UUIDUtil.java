package com.dreamer.education.utils;

import java.util.UUID;

public class UUIDUtil {

	/** 
     * 获得一个UUID 
     * @return String UUID 
     */ 
    public static String getUUID(){ 
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        return s; 
    } 
    
    public static void main(String...args){
    	System.out.println(UUIDUtil.getUUID());
    }
}
