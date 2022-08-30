package com.gao.util;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@ControllerAdvice
public class ControllerAdviceUtil {
    //捕获全局controller异常
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Map<String,Object> handlerException(){

        Map<String, Object> map = new HashMap<>();
        map.put("code","500");
        map.put("msg","程序异常");
        System.out.println(map);
        ThreadPoolExecutor newCachedThreadPool =(ThreadPoolExecutor) Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newCachedThreadPool();


        return map;
    }

    //@InitBinder
    //@ModelAttribute

}
