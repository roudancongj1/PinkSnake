package com.gao.util;



import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @Auth:Gao
 * @Date:2022-7-1
 *
 * 替代SpringBoot@Async注解 捕获线程异常
 * */
@Component
public class EAsync {


    private Integer maximumPoolSize = 10;

    private static ExecutorService executorService ;


    private EAsync() {
        executorService = Executors.newFixedThreadPool(maximumPoolSize);
    }


    public synchronized static void run(Runnable runnable) throws Exception {
        ExecutorService service = EAsync.executorService;
        Future<?> future = service.submit(runnable);
        future.get();

    }


}
