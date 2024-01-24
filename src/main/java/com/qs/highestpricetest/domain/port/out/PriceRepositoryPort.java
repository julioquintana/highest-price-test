package com.qs.highestpricetest.domain.port.out;

import com.qs.highestpricetest.domain.model.PriceDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public interface PriceRepositoryPort {
    Mono<PriceDto> findHighestPrice(Integer brandID, Integer productID, LocalDateTime purchaseDay);

    Flux<PriceDto> findAllById(Integer productID);

    Mono<PriceDto> update(PriceDto priceDto);

    Mono<PriceDto> findPriceById(Integer id);

}
