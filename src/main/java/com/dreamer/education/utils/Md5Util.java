package com.dreamer.education.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {
	public static String encode(String value) {  
        if (value == null) {  
            return null;  
        }  
        return DigestUtils.md5Hex(value);
    }
	
	
	public static String encode(byte[] value) {  
        if (value == null) {  
            return null;  
        }  
        return DigestUtils.md5Hex(value);
    }
	
	
	public static void main(String...args) throws UnsupportedEncodingException{
		String string = "be36dd6f5733fa09d1349c53cf2828811337330217840&timestamp=20111020135535&contentid=94&userid=123&priceid=123&productid=123";
//		String string = "asdfsadfsasadf爱上";
		String md5 = encode(string.getBytes("utf-8"));
		System.out.println(md5);
		System.out.println("D2B2B45B6C8AADEC7C0E078C26272B5A");
		System.out.println(System.currentTimeMillis());
	}
}
