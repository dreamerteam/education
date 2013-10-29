package com.dreamer.education.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Random;



/**
 * @createTime 2013-9-22上午11:09:44
 * @author wuqingjian
 * @version 1.0.0.0
 */
public class UploadUtil {
	
	public static String saveAudioFile(InputStream is) throws IOException{
		BufferedInputStream bis = new BufferedInputStream(is);
		byte[] byt = new byte[1024];
		String dir = "audio" + File.separator + DateUtil.getDateDirStr();
		File tmpDir = new File("save prifix" + File.separator + dir);
		boolean flag = true;
		if(!tmpDir.exists()){
			flag = tmpDir.mkdirs();
		}
		File file = null;
		Random r = new Random();
		String fileName = Md5Util.encode(Calendar.getInstance().getTimeInMillis()+
				""+r.nextInt(1000))+"file suffix";
		if(flag){
			file = new File(tmpDir, fileName);
			System.out.println(file.getAbsolutePath());
		}else{
			return null;
		}
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		try {
			int len = 0;
			while((len = bis.read(byt)) != -1){
				bos.write(byt, 0, len);
			}
		} finally{
			bis.close();
			bos.close();
		}
		String relativePath = dir + File.separator + fileName;
		return relativePath;
	}
	
}
