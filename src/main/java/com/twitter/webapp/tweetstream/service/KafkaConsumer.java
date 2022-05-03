package com.twitter.webapp.tweetstream.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    SimpMessagingTemplate template;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeTweets(@Payload String tweet) {
        System.out.println(tweet);
        template.convertAndSend("/topic/tweets", tweet);
    }


}
