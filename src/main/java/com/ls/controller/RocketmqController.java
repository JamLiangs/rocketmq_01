package com.ls.controller;

import com.ls.producer.RocketmqProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/MQTest")
public class RocketmqController {

    private final String topic ="TestTopic";

    @Autowired
    private RocketmqProducer producer;

    @RequestMapping("/sendMessage")
    public String sendMesssage(String message) throws MQBrokerException, RemotingException, InterruptedException, MQClientException, UnsupportedEncodingException {
        producer.sendMessage(topic,message);
        return "消息发送完成";
    }




}
