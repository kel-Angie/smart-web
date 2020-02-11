package com.smart.framework.utils;

import com.sun.istack.internal.Nullable;

import java.util.Collection;
import java.util.Map;

/**
 * @Description: 集合工具类
 * @Author: L.J.R
 * @Create: 2019/12/24 19:33
 **/
public class CollectionUtil {

    /**
     * @description: 判断集合是否为空
     * @author L.J.R
     * @date 2019/12/24 19:41
     * @param collection
     * @return boolean
     */
    public static boolean isEmpty(@Nullable Collection<?> collection){
        return collection == null || collection.isEmpty();
    }

    /**
     * @description: 判断map是否为空
     * @author L.J.R
     * @date 2019/12/24 19:41
     * @param map
     * @return boolean
     */
    public static boolean isEmpty(@Nullable Map<?,?> map){
        return map == null || map.isEmpty();
    }
}
