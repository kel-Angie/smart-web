package com.smart.framework.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description: 类型转换工具类
 * @Author: L.J.R
 * @Create: 2020/01/06 11:31
 **/
public class CastUtil {

    /**
     * @description: 转为string类型
     * @author L.J.R
     * @date 2020/1/6 11:52
     * @param obj
     * @return java.lang.String
     */
    public static String castString(Object obj){
        return CastUtil.castString(obj, "");
    }

    /**
     * @description: 转为string类型 添加默认
     * @author L.J.R
     * @date 2020/1/6 11:52
     * @param obj
     * @param defaultValue
     * @return java.lang.String
     */
    public static String castString(Object obj, String defaultValue){
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    /**
     * @description: 转double
     * @author L.J.R
     * @date 2020/1/8 20:20
     * @param obj
     * @return double
     */
    public static double castDouble(Object obj){
        return castDouble(obj, 0);

    }

    /**
     * @description: 转double 设置默认值
     * @author L.J.R
     * @date 2020/1/8 20:25
     * @param obj
     * @param defaultValue
     * @return double
     */
    public static double castDouble(Object obj, double defaultValue){
        double doubleValue = defaultValue;
        if (obj != null){
            String strValue = castString(obj);
            if (StringUtils.isNotBlank(strValue)){
                try {
                    doubleValue = Double.parseDouble(strValue);
                }catch (NumberFormatException e){
                    doubleValue = defaultValue;
                }
            }
        }
        return defaultValue;
    }
    
    /**
     * @description: 转int
     * @author L.J.R 
     * @date 2020/1/9 10:50
     * @param obj
     * @return int 
     */
    public static int cashInt(Object obj){
        return castInt(obj,0);
    }

    /**
     * @description: 转int 设置默认值
     * @author L.J.R
     * @date 2020/1/9 10:54
     * @param obj
     * @param defaultValue
     * @return int
     */
    public static int castInt(Object obj, int defaultValue) {
        int value = defaultValue;
        if (obj != null){
            String stringValue = castString(obj);
            if (StringUtils.isNotBlank(stringValue)){
                try {
                    value = Integer.parseInt(stringValue);
                }catch (NumberFormatException e){
                    value = defaultValue;
                }
            }
        }
        return value;
    }

    /**
     * @description: 转为long
     * @author L.J.R
     * @date 2020/1/9 14:27
     * @param obj
     * @return long
     */
    public static long castLong(Object obj){
        return castLong(obj, 0);

    }

    /**
     * @description: 转为long类型 设置默认值
     * @author L.J.R
     * @date 2020/1/9 14:28
     * @param obj
     * @param defaultValue
     * @return long
     */
    public static long castLong(Object obj, int defaultValue) {
        long value = defaultValue;
        if (obj != null){
            String stringValue = castString(obj);
            if (StringUtils.isNotBlank(stringValue)){
                try {
                    value = Long.parseLong(stringValue);
                }catch (NumberFormatException e){
                    value = defaultValue;
                }
            }
        }
        return value;
    }

    /**
     * @description: 转为Boolean
     * @author L.J.R
     * @date 2020/1/9 14:32
     * @param obj
     * @return boolean
     */
    public static boolean cashBoolean(Object obj){
        return castBoolean(obj, false);
    }

    /**
     * @description: 转为Boolean类型 提供默认值
     * @author L.J.R
     * @date 2020/1/9 14:32
     * @param obj
     * @param defaultValue
     * @return boolean
     */
    public static boolean castBoolean(Object obj, boolean defaultValue) {
        boolean value = defaultValue;
        if (obj != null){
            value = Boolean.parseBoolean(castString(obj));
        }
        return value;
    }

}
