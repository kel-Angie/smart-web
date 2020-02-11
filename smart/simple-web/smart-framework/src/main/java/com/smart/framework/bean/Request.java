package com.smart.framework.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @Description: 请求内容 请求方式及请求路径
 * @Author: L.J.R
 * @Create: 2020/01/10 09:15
 **/
public class Request {

    //请求方法
    private String requestMethod;
    //请求url
    private String requestUrl;

    public Request(String requestMethod, String requestUrl){
        this.requestMethod = requestMethod;
        this.requestUrl = requestUrl;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj){
        return EqualsBuilder.reflectionEquals(this,obj);
    }
}
