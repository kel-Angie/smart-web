package com.smart.framework.helper;

import com.smart.framework.helper.ClassHelper;
import com.smart.framework.utils.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description: bean-helper（bean容器）
 * @Author: L.J.R
 * @Create: 2019/12/24 17:42
 **/
public class BeanHelper {

    public static final Map<Class<?>,Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> cla : beanClassSet) {
            Object value = ReflectionUtil.newInstance(cla);
            BEAN_MAP.put(cla, value);
        }
    }

    /**
     * @description: 获取bean映射map
     * @author L.J.R 
     * @date 2019/12/24 18:30
     * @param 
     * @return java.util.Map<java.lang.Class<?>,java.lang.Object> 
     */
    public static Map<Class<?>,Object> getBeanMap(){
        return BEAN_MAP;
    }

    /**
     * @description: 获取实例
     * @author L.J.R
     * @date 2019/12/24 18:31
     * @param cla
     * @return T
     */
    public static <T> T getBean(Class<?> cla){
        if (!BEAN_MAP.containsKey(cla)){
            throw new RuntimeException("can not get bean by class:"+ cla);
        }
        return (T) BEAN_MAP.get(cla);
    }
}
