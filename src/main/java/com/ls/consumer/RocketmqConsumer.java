package com.ls.consumer;

import com.ls.producer.RocketmqProducer;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQReplyListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(consumerGroup = "${myrocketmq-config.my-consumer-group}",topic = "${myrocketmq-config.my-topic}")
public class RocketmqConsumer implements RocketMQListener {

    @Override
    public void onMessage(Object msg) {
        System.out.println("success consume message : " + msg);

    }
}
