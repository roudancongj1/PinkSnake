package com.pk.commonserver.util;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String,Object> {

    R(){
        put("code",0);
        put("status","success");
    }

    R(Integer code,String status){
        put("code",code);
        put("status",status);
    }

    R(Integer code,String status,String msg){
        put("code",code);
        put("status",status);
        put("msg",msg);
    }

    public static R ok(){
        return new R();
    }

    public static R ok(String msg){
        return new R(0,"success",msg);
    }

    public static R ok(Integer code,String status,String msg){
        return new R(code,status,msg);
    }

    public static R error(){
        return new R(500,"error");
    }

    public static R error(String msg){
        return new R(500,"error",msg);
    }

    public static R error(Integer code,String status,String msg){
        return new R(code,status,msg);
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public R put(Object data){
        this.put("data",data);
        return this;
    }

    public R put(Map<String,Object> map){
        this.putAll(map);
        return this;
    }
}
