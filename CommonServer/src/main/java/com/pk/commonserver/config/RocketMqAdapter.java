package com.pk.commonserver.config;


import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class RocketMqAdapter {

    @Autowired
    private RocketMQMessageConverter rocketMqMessageConverter;

    @Value("${rocketmq.name-server}")
    private String nameServer;

    public RocketMQTemplate getTemplateByTopic(String topic){
        RocketMQTemplate rocketMQTemplate = new RocketMQTemplate();
        DefaultMQProducer producer = new DefaultMQProducer(topic);
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
