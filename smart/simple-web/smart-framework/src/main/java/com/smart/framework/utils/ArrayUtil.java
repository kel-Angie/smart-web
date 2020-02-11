package com.smart.framework.utils;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @Description: 数组工具类
 * @Author: L.J.R
 * @Create: 2019/12/24 20:11
 **/
public class ArrayUtil {

    /**
     * @description: 判断数组为空
     * @author L.J.R
     * @date 2019/12/24 20:12
     * @param array
     * @return boolean
     */
    public static boolean isEmpty(Object[] array){
        return ArrayUtils.isEmpty(array);
    }

    /**
     * @description: 判断数组不为空
     * @author L.J.R
     * @date 2019/12/24 20:13
     * @param array
     * @return boolean
     */
    public static boolean isNotEmpty(Object[] array){
        return ArrayUtil.isNotEmpty(array);
    }

}
