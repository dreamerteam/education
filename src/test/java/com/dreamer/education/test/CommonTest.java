package com.dreamer.education.test;

import com.dreamer.education.utils.Encryption;
import com.dreamer.education.utils.StringUtils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class CommonTest {
    
    public static String getPinYin(String inputString) {
        
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
        char[] input = inputString.trim().toCharArray();
        StringBuffer output = new StringBuffer("");
        try {
            for (int i = 0; i < input.length; i++) {
                if (Character.toString(input[i]).matches("[\u4E00-\u9FA5]+")) {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);
                    output.append(temp[0]);
                    output.append(" ");
                } else
                    output.append(Character.toString(input[i]));
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return output.toString();
    }
    
    public static void main(String[] args) {  
//        String chs = "大兴安岭! I'm Chinese!";  
//        System.out.println(chs);  
//        System.out.println(getPinYin(chs));  
//        System.out.println(Encryption.MD5("1"));
//        System.out.println(StringUtils.getUUID());
        System.out.println("/manage/".matches("/manage/.*"));
        System.out.println("/page/manage/".matches("/page/manage/.*"));
    }  
    
}
