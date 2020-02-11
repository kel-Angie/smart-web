package com.smart.framework.bean;

import java.lang.reflect.Method;

/**
 * @Description: 处理action对象
 * @Author: L.J.R
 * @Create: 2020/01/10 09:26
 **/
public class Handle {

    /**
     * controller类
     */
    private Class<?> controllerClass;

    /**
     * action 方法
     */
    private Method actionMethod;


    public Handle(Class<?> controllerClass, Method actionMethod){
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }


}
