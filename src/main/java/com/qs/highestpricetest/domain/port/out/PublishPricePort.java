package com.qs.highestpricetest.domain.port.out;

import com.qs.highestpricetest.domain.model.PriceDto;
import reactor.core.publisher.Mono;

public interface PublishPricePort {

    Mono<Void> publish(PriceDto priceDto);
}
