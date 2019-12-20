package com.smart.framework.helper;

import com.smart.framework.annotation.Controller;
import com.smart.framework.annotation.Service;
import com.smart.framework.utils.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ljr
 * @Date: 2019/12/18 19:07
 * @Description: 类操作助手
 */
public final class ClassHelper {

    private static final Set<Class<?>> CLASS_SET;

    static {
        String packagePath = ConfigHelper.getPackagePath();
        CLASS_SET = ClassUtil.getClassSet(packagePath);
    }

    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }

    /**
     * @description: 获取应用包下所有service类
     */
    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> hashSet = new HashSet<Class<?>>();
        for (Class<?> temp : CLASS_SET) {
            if (temp.isAnnotationPresent(Service.class)){
                hashSet.add(temp);
            }
        }
        return hashSet;
    }

    /**
     * @description: 获取应用包下所有controller类
     */
    public static Set<Class<?>> getControllerSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> aClass : CLASS_SET) {
            if (aClass.isAnnotationPresent(Controller.class)){
                classSet.add(aClass);
            }
        }
        return classSet;
    }

    /**
     * @description: 获取应用下所有类（包括controller，service）
     */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> hashSet = new HashSet<Class<?>>();
        hashSet.addAll(getControllerSet());
        hashSet.addAll(getServiceClassSet());
        return hashSet;
    }
}
