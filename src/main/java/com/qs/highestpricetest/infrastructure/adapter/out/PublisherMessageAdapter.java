package com.qs.highestpricetest.infrastructure.adapter.out;

import com.qs.highestpricetest.domain.model.PriceDto;
import com.qs.highestpricetest.domain.port.out.PublishPricePort;
import com.qs.highestpricetest.infrastructure.publisher.PublisherKafka;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;


@AllArgsConstructor
public class PublisherMessageAdapter implements PublishPricePort {
    private final PublisherKafka publisherKafka;

    @Override
    public Mono<PriceDto> publish(PriceDto priceDto) {
       return publisherKafka.sendMessage(priceDto);
    }
}
