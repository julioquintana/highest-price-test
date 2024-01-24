package com.qs.highestpricetest.infrastructure.adapter.in.listener;

import com.qs.highestpricetest.domain.model.PriceDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class PriceListener {
    @KafkaListener(topics = "topic_test", groupId = "group_id")
    public void consume(PriceDto priceDto) {
        log.info(priceDto);
    }


}
