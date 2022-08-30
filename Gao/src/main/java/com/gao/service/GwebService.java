package com.gao.service;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface GwebService {
    @WebMethod(operationName = "rollBackParam")
    String rollBackParam(String param);

}
