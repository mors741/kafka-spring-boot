package com.mors741.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.topic.name}")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        log.info("receiving payload={} from topic={}", consumerRecord.value(), consumerRecord.topic());
    }
}
