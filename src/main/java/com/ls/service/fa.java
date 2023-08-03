package com.ls.service;



import org.apache.rocketmq.common.message.Message;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class fa {
    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        boolean andSet = atomicBoolean.getAndSet(true);
        System.out.println(atomicBoolean.get());
        System.out.println(andSet);

        Message message = new Message();
        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection,"test111","test222","test333");
        message.setKeys(collection);
        message.setTopic("TopicTest");
        System.out.println(message);
        System.out.println(message.getKeys());


    }

}
