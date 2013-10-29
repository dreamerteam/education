package com.dreamer.education.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


public class StringUtil {
	
	private static Logger logger = Logger.getLogger(StringUtil.class);

	public static final String Empty = "";
	public static final String URL_CONCAT="&";
	public static final String URL_BEGIN="?";
	public static final String PARA_EQUAL="=";

	public static Boolean isNullOrEmpty(String value) {
		return value == null || StringUtil.Empty.equals(value);
	}

	public static String getNumberString(String number, Integer count,
			String spot) {
		String temp = number;
		for (Integer i = temp.length(); i < count; i++) {
			temp = spot + temp;
		}
		return temp;
	}

	public static String getEmptyByNull(Object obj) {
		if (null == obj) {
			return Empty;
		}
		return obj.toString();
	}
	
	public static Integer getIntegerByStr(String str){
		try{
			Integer temp = Integer.parseInt(str);
			return temp;
		}catch (Exception e) {
			return null;
		}
	}

	public static String getURIEncodingParam(String urlParam, String encoding) {
		try {
			return new String(urlParam.getBytes("ISO-8859-1"), encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static boolean isNotEmpty(String o) {
		return !isNullOrEmpty(o);
	}

	public static String removeHtmlTag(String html) {
		String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(html);
		html = m_html.replaceAll(""); // 过滤html标签

		return html.trim(); // 返回文本字符串
	}

	public static List<String> toList(String str){
		if(str==null){
			return new ArrayList<String>();
		}
		return Arrays.asList(str.split("[,，| ]"));
	}
	
	public static String isNullToEmpty(Object s){
		if(null == s){
			return StringUtil.Empty;
		}
		return s.toString();
	}
	
	public static byte[] getStrBytes(String str, String charset){
		if(StringUtil.isNullOrEmpty(charset)){
			return str.getBytes();
		}

		try {
			return str.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	
	public static int getRandom(Integer min, Integer max){
		return  (int)(Math.random()*(max-min)+min);
	}
	
	public static String paraIsNullAndNotInt(String paraName,String paraValue){
		if(StringUtil.isNullOrEmpty(paraValue)){
			return paraName+"="+paraValue+",";
		}
		try{
			if(Integer.parseInt(paraValue) <= 0){
				return paraName+"="+paraValue+",";
			}
		}catch(Exception e){
			return paraName+"="+paraValue+",";
		}
		return "";
	}

	public static boolean paraNotNullAndNotInt(String paraName, String paraValue) {
		if(StringUtil.isNullOrEmpty(paraValue)){
			return true;
		}
		try{
			if(Integer.parseInt(paraValue) < 0){
				return true;
			}
		}catch(Exception e){
			return true;
		}
		return false;
	}

	public static boolean paraNotInt(String paraValue) {
		try{
			if(Integer.parseInt(paraValue) < 0){
				return true;
			}
		}catch(Exception e){
			return true;
		}
		return false;
	}
	
	public static String htmlEncode(String text){
		text = StringUtils.replace(text, "&", "&amp;");
		text = StringUtils.replace(text, "<", "&lt;" );
		text = StringUtils.replace(text, ">", "&gt;" );
		text = StringUtils.replace(text, "\"", "&quot;" );
		return text;
	}
	
	public static boolean isNumeric(String str){
		if(isNullOrEmpty(str)) return false;
	    Pattern pattern = Pattern.compile("[0-9]*");
	    return pattern.matcher(str).matches();   
	 } 
}
