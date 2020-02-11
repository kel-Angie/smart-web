package com.smart.framework.helper;

import com.smart.framework.annotation.Inject;
import com.smart.framework.utils.ArrayUtil;
import com.smart.framework.utils.CollectionUtil;
import com.smart.framework.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @Description: 控制反转 Inversion of Control
 * @Author: L.J.R
 * @Create: 2019/12/24 18:52
 **/
public class IocHelper {

    static {
        //获取所有bean map
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (!CollectionUtil.isEmpty(beanMap)){
            for (Map.Entry<Class<?>, Object> entry : beanMap.entrySet()) {
                //bean实例
                Object beanInstance = entry.getValue();
                //bean类
                Class<?> beanClass = entry.getKey();
                Field[] fieldArray = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(fieldArray)){
                    //遍历Field
                    for (Field field : fieldArray) {
                        //判断field是否带有注解@Inject
                        if (field.isAnnotationPresent(Inject.class)){
                            Class<?> classType = field.getType();
                            //获取实例
                            Object classBean = beanMap.get(classType);
                            if (classBean != null){
                                //反射设置Field值
                                ReflectionUtil.setField(beanInstance,field,classBean);
                        }

                        }
                    }
                }

            }
        }


    }


}
