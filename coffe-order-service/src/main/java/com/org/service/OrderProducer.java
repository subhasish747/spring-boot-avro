package com.org.service;


import com.learnavro.domain.generated.CoffeeOrder;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class OrderProducer {


    @Autowired
    private KafkaTemplate<String, CoffeeOrder> kafkaTemplate;

//    @Value("${kafka.producer.bootstrap-servers}")
    private String bootstrapServer ;


    private static final String TOPIC = "orders";

    public void sendOrder(CoffeeOrder order) {
        kafkaTemplate.send(TOPIC, String.valueOf(order.getId()) , order);
    }

    private void handleSuccess(RecordMetadata result) {
        log.info("Message sent successfully: {}", result);
    }

    private void handleFailure(CoffeeOrder message, Throwable ex) {
        log.error("Failed to send message: {}", message, ex);
    }




public Map<String, Object> getKafkaProducerProperties(){
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,CoffeeOrder.class);
       // config.put("schema.registry.url", )
        return config;
     }
}
