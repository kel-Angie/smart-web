package com.smart.framework.helper;

import com.smart.framework.annotation.Action;
import com.smart.framework.bean.Handle;
import com.smart.framework.bean.Request;
import com.smart.framework.utils.ArrayUtil;
import com.smart.framework.utils.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 控制器助手类
 * @Author: L.J.R
 * @Create: 2020/01/10 10:14
 **/
public final class ControllerHelper {

    /**
     * 用于存放请求与处理器的映射关系 简称ACTION_MAP
     */
    public static final Map<Request, Handle> ACTION_MAP = new HashMap<Request, Handle>();

    static {
        //获取所有controller类
        Set<Class<?>> controllerSet = ClassHelper.getControllerSet();
        if (!CollectionUtil.isEmpty(controllerSet)){
            for (Class<?> controllerClass : controllerSet) {
                //获取该类下所有方法
                Method[] methodArr = controllerClass.getDeclaredMethods();
                if (ArrayUtil.isNotEmpty(methodArr)){
                    for (Method method : methodArr) {
                        //判断当前方法是否有@Action注解
                        if (method.isAnnotationPresent(Action.class)){
                            Action actionMethod = method.getAnnotation(Action.class);
                            //注解上的value值
                            String actionValue = actionMethod.value();
                            //验证URL映射规则
                            if (actionValue.matches("\\w+:/\\w*")){
                                String[] actionValueArr = actionValue.split(":");
                                if (ArrayUtil.isNotEmpty(actionValueArr) && actionValueArr.length == 2){
                                    String requestMethod = actionValueArr[0];
                                    String requestUrl = actionValueArr[1];
                                    Request request = new Request(requestMethod, requestUrl);
                                    Handle handle = new Handle(controllerClass, method);
                                    ACTION_MAP.put(request, handle);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    /**
     * @description: 获取handle
     * @author L.J.R
     * @date 2020/1/10 11:04
     * @param requestMethod
     * @param requestUrl
     * @return com.smart.framework.bean.Handle
     */
    public static Handle getHandle(String requestMethod, String requestUrl){
        Request request = new Request(requestMethod, requestUrl);
        return ACTION_MAP.get(request);
    }
}
