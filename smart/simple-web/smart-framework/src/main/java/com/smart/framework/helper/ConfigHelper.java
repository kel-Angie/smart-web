package com.smart.framework.helper;

import com.smart.framework.common.contant.ConfigConstant;
import com.smart.framework.utils.PropsUtil;

import java.util.Properties;

/**
 * @author: ljr
 * @Date: 2019/12/12 19:35
 * @Description:
 */
public final class ConfigHelper {

    private static final Properties CONFIG_PROPERTIES = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    public static String getJdbcDriver(){
        return CONFIG_PROPERTIES.getProperty(ConfigConstant.JDBC_DRIVER);
    }

    public static String getJdbcUrl(){
        return CONFIG_PROPERTIES.getProperty(ConfigConstant.JDBC_URL);
    }

    public static String getJdbcUserName(){
        return CONFIG_PROPERTIES.getProperty(ConfigConstant.JDBC_USERNAME);
    }

    public static String getJdbcPassword(){
        return CONFIG_PROPERTIES.getProperty(ConfigConstant.JDBC_PASSWORD);
    }

    public static String getPackagePath(){
        return CONFIG_PROPERTIES.getProperty(ConfigConstant.BASE_PACKAGE_PATH);
    }

    public static String getJspBasePath(){
        return CONFIG_PROPERTIES.getProperty(ConfigConstant.JSP_BASE_PATH, "WEB-INFO/view/");
    }

    public static String getAppAssetPath(){
        return CONFIG_PROPERTIES.getProperty(ConfigConstant.ASSET_PATH, "/asset/");
    }
}
