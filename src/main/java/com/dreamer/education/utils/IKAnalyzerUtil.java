package com.dreamer.education.utils;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
//import org.wltea.analyzer.lucene.IKAnalyzer;
/**
 * @createTime 2013-9-26下午6:07:26
 * @author wuqingjian
 * @version 1.0.0.0
 */
public class IKAnalyzerUtil {
	/*public static Set<String> IKAnalyzer(String msg){
		Set<String> wordSet = new HashSet<String>();
		Analyzer analyzer = new IKAnalyzer(true);
		StringReader reader = new StringReader(msg);
		TokenStream ts = null;
		try{
			ts = analyzer.tokenStream("", reader);
			//获取词元文本属性
			CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
			//重置TokenStream (重置StringReader)
			ts.reset();
			while(ts.incrementToken()){
				String tmpKey = term.toString();
				if(tmpKey.length() > 1){
					wordSet.add(tmpKey);
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			//释放TokenStream的所有资源
			if(ts != null){
				try{
					ts.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		reader.close();
		return wordSet;
	}
	
	public static void main(String[] args) {
//		Set<String> set = new HashSet<String>();
		Set<String> set = IKAnalyzerUtil.IKAnalyzer("请问600595表现如何,安徽水利呢,金晶科技？ ");
		System.out.println(set.size());
		for(String s : set){
			System.out.println(s);
		}
//		while(set.iterator().hasNext()){
//			System.out.println(set.iterator().next());
//		}
	}*/
}
