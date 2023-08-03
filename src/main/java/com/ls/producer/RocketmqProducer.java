package com.ls.producer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class RocketmqProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    // 发送消息的实例
    public void sendMessage(String topic, String msg) throws MQBrokerException, RemotingException, InterruptedException, MQClientException, UnsupportedEncodingException {
//        rocketMQTemplate.convertAndSend(topic, msg);
//        SendResult sendResult = rocketMQTemplate.syncSend(topic, msg);
//        System.out.println("返回结果:" + sendResult);



        defaultMQProducer = new DefaultMQProducer("ProducerGroupName");
        defaultMQProducer.start();

        Message message = new Message();
//        "TestTopic","TagA","OrderID188","Hello world"
//                .getBytes(RemotingHelper.DEFAULT_CHARSET)
        message.setTopic(topic);
        message.setBody(msg.getBytes(RemotingHelper.DEFAULT_CHARSET));
        System.out.println(message);
        SendResult send = defaultMQProducer.send(message, 10000);
        System.out.println(send);
        defaultMQProducer.shutdown();

    }
}
