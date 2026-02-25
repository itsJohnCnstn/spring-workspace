package com.johncnstn.kafkaexample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "johncnstn",
            //if app scales groupId is used to make possible for scaled instances to
            //read from the same partition or topic
            groupId = "groupId"
    )

    void listener(String data) {
        System.out.println("Listener received: " + data + " WOW!!");
    }

}
