package com.smart.framework.bean;

import com.smart.framework.utils.CastUtil;

import java.util.Map;

/**
 * @Description: 请求参数
 * @Author: L.J.R
 * @Create: 2020/01/10 14:24
 **/
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String,Object> paramMap){
        this.paramMap = paramMap;
    }

    /**
     * @description: 根据参数名获取long类型参数值
     * @author L.J.R 
     * @date 2020/1/10 14:30
     * @param name
     * @return long 
     */
    public long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     * @description: 获取请求参数
     * @author L.J.R
     * @date 2020/1/10 14:31
     * @param
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public Map<String,Object> getParamMap(){
        return paramMap;
    }
}
