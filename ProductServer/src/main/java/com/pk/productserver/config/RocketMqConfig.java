package com.pk.productserver.config;


import com.pk.commonserver.config.RocketMqAdapter;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@RefreshScope
public class RocketMqConfig {
    @Autowired
    private RocketMqAdapter rocketMqAdapter;


    @Lazy
    @Bean(destroyMethod = "destroy")
    public RocketMQTemplate stockMqTemplate() {
        return rocketMqAdapter.getTemplateByProducerGroup("producer-group");
    }


    /*@Lazy
    @Bean(destroyMethod = "destroy")
    public RocketMQTemplate orderCancelTemplate() {
        return rocketMqAdapter.getTemplateByTopicName(RocketMqConstant.ORDER_CANCEL_TOPIC);
    }

    @Lazy
    @Bean(destroyMethod = "destroy")
    public RocketMQTemplate orderNotifyStockTemplate() {
        return rocketMqAdapter.getTemplateByTopicName(RocketMqConstant.ORDER_NOTIFY_STOCK_TOPIC);
    }*/
}
