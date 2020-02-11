package com.smart.framework;

import com.smart.framework.annotation.Controller;
import com.smart.framework.helper.BeanHelper;
import com.smart.framework.helper.ClassHelper;
import com.smart.framework.helper.ControllerHelper;
import com.smart.framework.helper.IocHelper;
import com.smart.framework.utils.ClassUtil;
import org.junit.Test;

/**
 * @Description: 加载helper
 * @Author: L.J.R
 * @Create: 2020/01/10 11:20
 **/
public class HelperLoad {

    @Test
    public void init(){
        Class<?>[] listClass = {
                BeanHelper.class,
                ClassHelper.class,
                ControllerHelper.class,
                IocHelper.class
        };

        for (Class<?> aclass : listClass) {
            Class<?> aClass = ClassUtil.loadClass(aclass.getName(), false);
            System.out.println(aClass.getName());
        }
    }
}
