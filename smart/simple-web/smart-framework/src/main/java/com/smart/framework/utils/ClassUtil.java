package com.smart.framework.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author: ljr
 * @Date: 2019/12/16 11:30
 * @Description:
 */
public class ClassUtil {

    public static void main(String[] args) {
        Set<Class<?>> classSet = getClassSet("com.smart.framework");
        for (Class<?> aClass : classSet) {
            System.out.println(aClass);
        }
    }

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

    /**
     * @description: 获取指定包名下所有类
     * @author linjiarui
     * @date 2019/12/17 9:51
     * @param packageName
     * @return java.util.Set<java.lang.Class<?>>
     */
    public static Set<Class<?>> getClassSet(String packageName){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        try {
            String replace = packageName.replace(".", "/").substring(0);
            Enumeration<URL> urls = getClassLoader().getResources(replace);
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                if (url != null){
                    String protocol = url.getProtocol();
                    if ("file".equals(protocol)){
                        String packagePath = url.getPath().replace("%20", "");
                        addClass(classSet, packagePath, packageName);
                    }
                    else if ("jar".equals(protocol)){
                        JarURLConnection jarURLConnection = (JarURLConnection)url.openConnection();
                        if (jarURLConnection != null){
                            JarFile jarFile = jarURLConnection.getJarFile();
                            if (jarFile != null){
                                Enumeration<JarEntry> jarEntry = jarFile.entries();
                                while (jarEntry.hasMoreElements()){
                                    JarEntry jarEntry1 = jarEntry.nextElement();
                                    String jarEntry1Name = jarEntry1.getName();
                                    if (jarEntry1Name.endsWith(".class")){
                                        String className = jarEntry1Name.substring(0, jarEntry1Name.lastIndexOf("."));
                                        doAddClass(classSet, className);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }catch (IOException e){
            logger.error("get Class Set failure", e);
            throw new RuntimeException(e);
        }
        return classSet;
    }

    private static void addClass(Set<Class<?>> classSet, String packagePath, String packageName) {
       File[] files = new File(packagePath).listFiles(new FileFilter() {
            public boolean accept(File file) {
                return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
            }
        });
       for (File file: files){
           String fileName = file.getName();
           if (file.isFile()){
               String className = file.getName().substring(0, file.getName().lastIndexOf("."));
               if (StringUtils.isNotBlank(packageName)){
                   className = packageName + "." + className;
               }
               doAddClass(classSet, className);
           }else {
               String subPackagePath = fileName;
               if (StringUtils.isNotBlank(packagePath)){
                   subPackagePath = packagePath + "/" + subPackagePath;
               }
               String subPackageName = fileName;
               if (StringUtils.isNotBlank(packageName)){
                   subPackageName = packageName + "." + subPackageName;
               }
               addClass(classSet, subPackagePath, subPackageName);
           }
       }


    }

    private static void doAddClass(Set<Class<?>> classSet, String className) {
        Class<?> aClass = loadClass(className, false);
        classSet.add(aClass);
    }


}
