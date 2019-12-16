package com.smart.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: ljr
 * @Date: 2019/12/16 11:30
 * @Description:
 */
public class ClassUtil {

    private static final Logger logger = LoggerFactory.getLogger(ClassUtil.class);

    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String className, boolean initialized){
        Class<?> cls;
        try {
            cls = Class.forName(className, initialized, getClassLoader());
        }catch (ClassNotFoundException e){
            logger.error("load class failure", e);
            throw new RuntimeException(e);
        }
        return cls;
    }



}
