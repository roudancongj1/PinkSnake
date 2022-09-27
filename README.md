# PinkSnake
<br>
Auth:GuangYun Gao

微服务商城
采用Nacos+Kafaka+RocketMQ

采用Jwt式校验，token在请求头传输，经Aop校验ThreadLocal确认登录身份后才可访问接口

####先 maven install本地后可打包

###1.登陆测试用户 localhost:8903/user/loginTestUser get请求

###2.下单接口  localhost:8901/order/create  post请求

JSON

{

    "product": "",
    "timestamp": "",
}
###3.查询订单 localhost:8901/order/query get请求

{

    "orderId": "",
    "timestamp": "",
}

