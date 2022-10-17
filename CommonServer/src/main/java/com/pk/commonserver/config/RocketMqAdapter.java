package com.pk.commonserver.config;


import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope /*动态刷新配置*/
public class RocketMqAdapter {

    @Autowired
    private RocketMQMessageConverter rocketMqMessageConverter;

    @Value("${rocketmq.name-server}")//name-server -> topic -> queue
    private String nameServer;

    public RocketMQTemplate getTemplateByProducerGroup(String producerGroup){
        RocketMQTemplate rocketMQTemplate = new RocketMQTemplate();
        //producer set message object Temp set Object
        DefaultMQProducer producer = new DefaultMQProducer(producerGroup);
        //MQ地址
        producer.setNamesrvAddr(nameServer);
        //失败重试次数
        producer.setRetryTimesWhenSendFailed(2);
        //超时时间
        producer.setSendMsgTimeout(3000);
        rocketMQTemplate.setProducer(producer);
        //消息转换
        rocketMQTemplate.setMessageConverter(rocketMqMessageConverter.getMessageConverter());

        return rocketMQTemplate;
    }

}
