package com.gao.service;

import org.springframework.stereotype.Service;

@Service
public class eService {

    public void e(){
        //int a = 1/0;
        Integer a = null;
        a.toString();
        Integer b = 3 / a;
    }
}
