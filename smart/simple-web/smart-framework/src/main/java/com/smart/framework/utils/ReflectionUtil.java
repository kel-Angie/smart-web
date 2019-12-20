package com.smart.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author: L.J.R
 * @Date: 2019/12/20 19:21
 * @Description:
 */
public class ReflectionUtil {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * @description: 创建实例
     * @author L.J.R 
     * @date 2019/12/20 19:36
     * @param cla
     * @return java.lang.Object 
     */
    public static Object newInstance(Class<?> cla){
        Object instance;
        try {
            instance = cla.newInstance();
        }catch (IllegalAccessException e){
            logger.error("new instance failure", e);
            throw new RuntimeException(e);
        }catch (InstantiationException e1){
            logger.error("new instance failure", e1);
            throw new RuntimeException(e1);
        }
        return instance;
    }

    /**
     * @description: 调用方法
     * @author L.J.R 
     * @date 2019/12/20 19:49
     * @param obj
     * @param method
     * @param args
     * @return java.lang.Object 
     */
    public static Object invokeMethod(Object obj, Method method, Object... args){
        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(obj,args);
        }catch (Exception e){
            logger.error("invoke method failure", e);
            throw new RuntimeException(e);
        }
        return result;
    }
}
