package com.gao.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.locks.ReentrantLock;

@Controller
public class webController {
    private static final Logger log = LoggerFactory.getLogger(webController.class);

    @RequestMapping("index")
    public String web() throws InterruptedException {

        synchronized (this){
            int a=5;
            for (int i = a; i >0; i--) {
                System.out.println("this minute is"+ i +this.getClass() + Thread.currentThread() );
                //this.getName();
                Thread.sleep(1*1000);
            }

            log.info("线程结束");

        }
        return "index.html";
    }


    @RequestMapping("index2")
    public String web2() {

        final ReentrantLock lock = new ReentrantLock(true);

        lock.lock();
        try {
            int a=5;
            Thread.sleep(5*1000);
            for (int i = a; i >0; i--) {
                System.out.println("this minute is"+ i +lock);

            }

            log.info("线程结束");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


        return "index.html";
    }

    @RequestMapping("index3")
    public String web3() throws InterruptedException {


        int a=5;
        for (int i = a; i >0; i--) {
            System.out.println("this minute is"+ i +this.getClass());
            Thread.sleep(1*1000);
        }

        log.info("线程结束");


        return "index.html";
    }

}
