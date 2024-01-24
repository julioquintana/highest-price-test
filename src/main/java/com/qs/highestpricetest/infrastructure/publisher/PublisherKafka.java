package com.qs.highestpricetest.infrastructure.publisher;

import com.qs.highestpricetest.domain.model.PriceDto;
import com.qs.highestpricetest.infrastructure.util.PropertyValues;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class PublisherKafka {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final PropertyValues propertyValues;


    public Mono<Void> sendMessage(PriceDto message) {
        return Mono.fromRunnable(() -> kafkaTemplate.send(propertyValues.getTopic(), message.toString()).toCompletableFuture())
                .then();
    }
}
