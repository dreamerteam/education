package com.dreamer.education.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.log4j.Logger;

public class HttpUtil {
	private static Logger logger = Logger.getLogger(HttpUtil.class);

	/**
	 * 执行一个HTTP GET请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param queryString
	 *            请求的查询参数,可以为null
	 * @param charset
	 *            字符集
	 * @param pretty
	 *            是否美化
	 * @return 返回请求响应的HTML
	 */
	public static void doGet(String url, String queryString) {		
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(url);
		try {
			if (!StringUtil.isNullOrEmpty(queryString))
				method.setQueryString(URIUtil.encodeQuery(queryString));
			client.executeMethod(method);			
		} catch (URIException e) {
			logger.error("执行HTTP Get请求时，编码查询字符串“" + queryString + "”发生异常！", e);
		} catch (IOException e) {
			logger.error("执行HTTP Get请求" + url + "时，发生异常！", e);
		} finally {
			method.releaseConnection();
		}
	}
	
	/**
	 * 执行一个HTTP GET请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param queryString
	 *            请求的查询参数,可以为null
	 * @param charset
	 *            字符集
	 * @param pretty
	 *            是否美化
	 * @return 返回请求响应的HTML
	 */
	public static String doGet(String url, String queryString, String charset,
			boolean pretty) {
		StringBuilder response = new StringBuilder();
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(url);
		try {
			if (!StringUtil.isNullOrEmpty(queryString))
				method.setQueryString(URIUtil.encodeQuery(queryString));
//			logger.info(method.getURI().toString());
			
//			method.addRequestHeader("Content-Type",
//					"application/x-www-form-urlencoded; textml; charset=" + charset);
			
			client.executeMethod(method);
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(method.getResponseBodyAsStream(),
								charset));
				String line;
				while ((line = reader.readLine()) != null) {
					if (pretty)
						response.append(line).append(
								System.getProperty("line.separator"));
					else
						response.append(line);
				}
				reader.close();
			}
		} catch (URIException e) {
			logger.error("执行HTTP Get请求时，编码查询字符串“" + queryString + "”发生异常！", e);
		} catch (IOException e) {
			logger.error("执行HTTP Get请求" + url + "时，发生异常！", e);
		} finally {
			method.releaseConnection();
		}
		return response.toString();
	}

	/**
	 * 执行一个HTTP POST请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param params
	 *            请求的查询参数,可以为null
	 * @param charset
	 *            字符集
	 * @param pretty
	 *            是否美化
	 * @return 返回请求响应的HTML
	 */
	public static String doPost(String url, Map<String, String> params,
			String charset, boolean pretty) {
		PostMethod method = null;
		StringBuffer response = new StringBuffer();
		try {
			HttpClient client = new HttpClient();
			method = new PostMethod(url);
			// 设置Http Post数据
			if (params != null) {
				NameValuePair[] values = new NameValuePair[params.size()];
				List<NameValuePair> postValues = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> entry : params.entrySet()) {
					try {
						postValues.add(new NameValuePair(entry.getKey(), URIUtil.encodeQuery(entry.getValue(), charset)));
					} catch (URIException e) {
						e.printStackTrace();
						postValues.add(new NameValuePair(entry.getKey(), entry.getValue()));
					}
				}
				values = postValues.toArray(values);
				method.setRequestBody(values);
			}
			client.executeMethod(method);
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(method.getResponseBodyAsStream(),charset));
				String line;
				while ((line = reader.readLine()) != null) {
					if (pretty){
						response.append(line).append(System.getProperty("line.separator"));
					}else{
						response.append(line);
					}
				}
				reader.close();
			}
		}catch (IOException e) {
			e.printStackTrace();
			logger.error("执行HTTP Post请求" + url + "时，发生异常！", e);
		} finally {
			if(method != null){
				method.releaseConnection();
			}
		}
		return response.toString();

	}

	
	
	/**
     * 发送Http请求
     * 
     * @param m 请求发送方式：POST or GET
     * @param urlStr 请求地址和参数
     * @param proxy 代理服务器IP
     * @param proxyPort 代理服务器端口
     */
    public static String doPost(String url, Map<String, String> params){
        String rs = "";
        PostMethod method = null;
        try{
            HttpClient client = new HttpClient();   
            method = new PostMethod(url);// m.equalsIgnoreCase(HttpUtils.METHOD_GET)?new GetMethod(urlStr):new PostMethod(urlStr);
            
            if(null != params){
	            for(String s : params.keySet()){
	            	method.setParameter(s, new String(params.get(s).getBytes("utf-8"), "ISO-8859-1"));
	            }
            }
//            System.out.println(" method.getResponseCharSet():"+ method.getResponseCharSet());
            client.executeMethod(method);
            rs = method.getResponseBodyAsString();
        }catch(Exception e){
            e.printStackTrace();
            logger.error("send http request error!", e);
        }finally{
            if(method != null){
                method.releaseConnection();
            }
        }
        return rs;
    }  
	
	
    /**
     * 发送Http请求
     * 
     * @param m 请求发送方式：POST or GET
     * @param urlStr 请求地址和参数
     * @param proxy 代理服务器IP
     * @param proxyPort 代理服务器端口
     */
    public static String doPostXml(String url, String xml){
        String rs = "";
        PostMethod method = null;
        try{
            HttpClient client = new HttpClient();   
            method = new PostMethod(url);// m.equalsIgnoreCase(HttpUtils.METHOD_GET)?new GetMethod(urlStr):new PostMethod(urlStr);
            
            method.setRequestBody(xml);
            
            client.executeMethod(method);
			rs = method.getResponseBodyAsString();
        }catch(Exception e){
            e.printStackTrace();
            logger.error("send http request error!", e);
        }finally{
            if(method != null){
                method.releaseConnection();
            }
        }
        return rs;
    }  
    public static void main(String[] args) {
		String str = HttpUtil.doGet(" http://192.168.35.88:8989/bms_pc_adapter/queryUserInfo?accountNo=haiying925@yahoo.cn", null,"utf-8",false);
	}

}