package com.pk.commonserver.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public Boolean set(String key,Object value){
        try {
            //默认十分钟过期
            redisTemplate.opsForValue().set(key,value,10*60, TimeUnit.SECONDS);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Boolean set(String str ,Object o,int expire){
        try {

            redisTemplate.opsForValue().set(str,o,expire, TimeUnit.MINUTES);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public Object get(String str){
        try {
            return redisTemplate.opsForValue().get(str);
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean delete(String str){
        try {
            return redisTemplate.delete(str);
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean hasKey(String str){
        try {
            return redisTemplate.hasKey(str);
        } catch (Exception e) {
            return false;
        }
    }

}