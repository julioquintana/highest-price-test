package com.qs.highestpricetest.domain.port.in;

import com.qs.highestpricetest.domain.model.PriceDto;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public interface FindPriceUseCase {
    Mono<PriceDto> find(Integer brandID, Integer productID, LocalDateTime purchaseDay);

}
