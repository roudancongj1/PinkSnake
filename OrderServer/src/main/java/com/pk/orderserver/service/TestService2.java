package com.pk.orderserver.service;

import com.pk.commonserver.pojo.AVB;
import com.pk.commonserver.util.TopicBy;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RocketMQMessageListener(topic = TopicBy.PRODUCT,consumerGroup = TopicBy.PRODUCT)
public class TestService2 implements RocketMQListener<String> {

    private static final Logger log = LoggerFactory.getLogger(TestService2.class);

    @Autowired
    private RocketMQTemplate stockMqTemplate;


    @Override
    public void onMessage(String avb) {
        log.info("--------------------------------监听成功，开始执行----------------------------");
        log.info("您传入的对象是:"+avb);
        log.info("--------------------------------运行结束------------------------------------");
        //stockMqTemplate.syncSend()

    }
}
