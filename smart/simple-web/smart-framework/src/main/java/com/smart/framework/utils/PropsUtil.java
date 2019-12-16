package com.smart.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: ljr
 * @Date: 2019/12/13 20:02
 * @Description:
 */
public class PropsUtil {

    private static final Logger logger = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * @description: 加载配置文件
     * @author linjiarui
     * @date 2019/12/16 10:49
     * @param fileName
     * @return java.util.Properties
     */
    public static Properties loadProps(String fileName){
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (inputStream == null){
                throw new FileNotFoundException(fileName + "file is not found!");
            }
            properties.load(inputStream);
        }catch (IOException e){
            logger.info("load properties file failure",e);
            }
        finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                }catch (IOException ie){
                    logger.info("close input stream failure",ie);
                }
            }
        }

        return properties;
    }

    /**
     * @description: 字符类型值 默认空字符串
     * @author linjiarui
     * @date 2019/12/16 10:47
     * @param properties
     * @param key
     * @return java.lang.String
     */
    public static String getString(Properties properties, String key){
        return properties.getProperty(key,"");
    }

    /**
     * @description: 获取字符类型值 指定默认值
     * @author linjiarui
     * @date 2019/12/16 10:54
     * @param properties
     * @param key
     * @param defaultKye
     * @return java.lang.String
     */
    public static String getString(Properties properties, String key, String defaultKye){
        String value = defaultKye;
        if (properties.contains(key)){
            value = properties.getProperty(key);
        }
        return value;
    }


}
