package com.gao.util;



import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Session 仅可取一次值
 * */
public class RamSession {

    private static final ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<>();

    private static final String[] sessionAttributes = {"requestID","bussinessID"};

    static {
        for (String attribute : sessionAttributes) {
            map.put(attribute,"default");
        }
    }

    public static ConcurrentHashMap<String,Object> get(){

        ConcurrentHashMap<String, Object> paramMap = new ConcurrentHashMap<>(map);
        /*paramMap.forEach((K,V)->{
            if (V.toString().equals("default")){
                paramMap.remove(K);
            }
        });*/
        map.clear();
        return paramMap;
    }

    public static synchronized void set(Map<String,Object> paramMap){

        map.putAll(paramMap);
    }

}
