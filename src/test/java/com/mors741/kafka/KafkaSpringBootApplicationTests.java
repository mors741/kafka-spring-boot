package com.mors741.kafka;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class KafkaSpringBootApplicationTests {

    private static String BOOT_TOPIC = "mytopic";

    @ClassRule
    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, BOOT_TOPIC);

    @Autowired
    private KafkaProducer producer;

    @Autowired
    private KafkaConsumer consumer;

    @Test
    public void testReceive() throws Exception {
        Thread.sleep(10000);
        producer.send(BOOT_TOPIC, "Hello Kafka!");
        Thread.sleep(1000);
        producer.send(BOOT_TOPIC, "How are you?");
        Thread.sleep(1000);
        producer.send(BOOT_TOPIC, "Bye bye!");
        Thread.sleep(1000);

    }

}
