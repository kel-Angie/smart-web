package com.smart.framework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 视图对象
 * @Author: L.J.R
 * @Create: 2020/01/10 15:46
 **/
public class View {

    /**
     * 视图路径
     */
    private String viewPath;

    /**
     * 模型数据
     */
    private Map<String,Object> model;

    public View(String viewPath){
        this.viewPath = viewPath;
        model = new HashMap<String, Object>();
    }

    public View addModel(String key, Object value){
        model.put(key, value);
        return this;
    }

    public String getViewPath(){
        return viewPath;
    }

    public Map<String, Object> getModel(){
        return model;
    }
}
