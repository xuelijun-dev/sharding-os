package com.greenbon.base.comm;


import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * 字符串工具类
 *
 * @author open_developer
 */
public class StringUtils{

    public static boolean isStrEmpty(String str) {
        return str == null || "".equals(str) || 0 == str.length();
    }

    public static boolean isArrayEmpty(String[] array) {
        return array == null || array.length == 0;
    }

    public static String allTrim(String str) {
        return str.replace(" ", "");
    }

    public static String trim(String str, String p) {
        while(str.indexOf(p) == 0) {
            str = str.substring(p.length());
        }

        while(str.lastIndexOf(p) == str.length() - p.length()) {
            str = str.substring(0, str.length() - p.length());
        }

        return str;
    }


    /**
     * 是否包含字符串
     *
     * @param str 验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strs)
    {
        if (str != null && strs != null)
        {
            for (String s : strs)
            {
                if (str.equalsIgnoreCase(s.trim()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 字符串转Unicode编码
     *
     * @param str
     * @return
     */
    public static String string2Unicode(String str) {
        StringBuilder unicode = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            unicode.append("\\u").append(Integer.toHexString(c));
        }
        return unicode.toString();
    }

    /**
     * Unicode编码转字符串
     *
     * @param unicode
     * @return
     */
    public static String unicode2String(String unicode) {
        StringBuilder string = new StringBuilder();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            int data = Integer.parseInt(hex[i], 16);
            string.append((char) data);
        }
        return string.toString();
    }





    /**
     * 混淆手机号码
     *
     * @param mobile eg:13106656773=>131****6773
     * @return
     */
    public static String confuseMobile(String mobile) {
        if (mobile.length() != 11) {
            return mobile;
        }
        StringBuilder sBuffer = new StringBuilder("");
        for (int i = 0; i < 4; i++) {
            sBuffer.append("*");
        }
        return mobile.replaceAll(mobile.substring(3, 7), sBuffer.toString());
    }


    /**
     * 转换成字符串
     *
     * @param obj
     * @return
     */
    public static String value(Object obj) {
        if (obj == null) {
            return null;
        } else {
            return String.valueOf(obj);
        }
    }

    /**
     * 生成UUID
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    /**
     * 获取随机数字
     *
     * @param length 长度
     * @return
     */
    public static String getRandomNum(int length) {
        // 35是因为数组是从0开始的，26个字母+10个数字
        int maxNum = 36;
        // 生成的随机数
        int i;
        // 生成的密码的长度
        int count = 0;
        char[] str = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuilder randomStr = new StringBuilder();
        Random r = new Random();
        while (count < length) {
            // 生成随机数，取绝对值，防止生成负数，
            // 生成的数最大为36-1
            i = Math.abs(r.nextInt(maxNum));
            if (i >= 0 && i < str.length) {
                randomStr.append(str[i]);
                count++;
            }
        }

        return randomStr.toString();
    }

    /**
     * 生成随便字母数字
     *
     * @param length
     * @return
     */
    public static String getRandom(int length) {
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }


    /**
     * 多个字符串与比较值进行比较，忽略大小写，如果存在一个值相等的，返回true
     *
     * @param compare 比较值
     * @param strs
     * @return
     */
    public static boolean equalOneIgnoreCase(String compare, String... strs) {
        for (String str : strs) {
            if (compare.equalsIgnoreCase(str)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 多个字符串与比较值进行比较，如果存在一个值相等的，返回true
     *
     * @param compare 比较值
     * @param strs
     * @return
     */
    public static boolean equalOne(String compare, String... strs) {
        for (String str : strs) {
            if (compare.equals(str)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 多个字符串与比较值进行比较，如果存在一个值相等的，返回true
     *
     * @param compare 比较值
     * @param strs
     * @return
     */
    public static boolean equalOne(char compare, String... strs) {
        String c = String.valueOf(compare);

        for (String str : strs) {
            if (c.equals(str)) {
                return true;
            }
        }

        return false;
    }


    /**
     * 首字母大写
     *
     * @param name
     * @return
     */
    public static String upCaseFirst(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }


    /**
     * 按要求自动补全数值
     *
     * @param number
     * @param length 长度，不够前面加0
     * @return
     */
    public static String fullNumber(String number, int length) {
        StringBuilder sbf = new StringBuilder();
        int l = length - number.length();
        for (int i = 0; i < l; i++) {
            sbf.append("0");
        }
        return sbf.append(number).toString();
    }


    /**
     * 获取 中文字符的长度，ed=>“测试” return 2,
     *
     * @param text
     * @return
     */
    public final static float getLength(String text) {
        int length = 0;
        for (int i = 0; i < text.length(); i++) {
            if (new String(text.charAt(i) + "").getBytes().length > 1) {
                length += 2;
            } else {
                length += 1;
            }
        }
        return (float) length / 2;
    }

    /**
     * 字符串替换，第几个到
     *
     * @param sourceStr  原始字符串
     * @param targetStr  替换成字符串
     * @param startIndex
     * @param endIndex
     * @return
     */
    public  static String replace(String sourceStr, String targetStr, int startIndex, int endIndex) {
        return sourceStr.substring(0, startIndex) + targetStr + sourceStr.substring(endIndex, sourceStr.length());
    }

    /***
     * 下划线命名转为驼峰命名
     *
     * @param para
     *        下划线命名的字符串
     */

    public static String underlineToHump(String para) {
        StringBuilder result = new StringBuilder();
        String a[] = para.split("_");
        for (String s : a) {
            if (!para.contains("_")) {
                result.append(s);
                continue;
            }
            if (result.length() == 0) {
                result.append(s.toLowerCase());
            } else {
                result.append(s.substring(0, 1).toUpperCase());
                result.append(s.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }


    /***
     * 驼峰命名转为下划线命名
     *
     * @param para
     *        驼峰命名的字符串
     */

    public static String humpToUnderline(String para) {
        if (ObjectUtils.isEmpty(para)){
            return "";
        }
        StringBuilder sb = new StringBuilder(para);
        //定位
        int temp = 0;
        if (!para.contains("_")) {
            for (int i = 0; i < para.length(); i++) {
                if (Character.isUpperCase(para.charAt(i))) {
                    sb.insert(i + temp, "_");
                    temp += 1;
                }
            }
        }
        return sb.toString().toUpperCase();
    }

    /**
     * @param prefix 业务前缀，如 "LB" + System.currentTimeMillis() + getRandomNum(4);
     * return 生成规则，时间戳加随机数
     */
    public static String createOrderNo(String prefix) {
        return prefix + System.currentTimeMillis() + getRandomNum(4);
    }


    public static void main(String[] args)  {
        char[] byteArray = {8,205,1,0,1,169,123,34,99,109,100,34,58,49,48,48,52,44,34,99,108,105,101,110,116,73,100,34,58,34,49,48,48,49,50,55,53,51,48,49,54,56,54,56,49,55,55,51,52,53,57,54,56,50,34,44,34,112,97,114,97,115,34,58,123,34,116,121,112,101,34,58,49,44,34,115,101,109,97,112,104,111,114,101,115,34,58,50,57,44,34,101,114,114,76,105,115,116,34,58,91,123,34,88,34,58,49,44,34,89,34,58,49,44,34,115,116,97,116,117,115,34,58,48,125,44,123,34,88,34,58,50,44,34,89,34,58,49,44,34,115,116,97,116,117,115,34,58,48,125,93,125,125};
        String str = new String(byteArray);
        System.out.println(str);

    }
}
