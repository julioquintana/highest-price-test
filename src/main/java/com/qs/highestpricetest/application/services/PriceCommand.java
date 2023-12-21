package com.qs.highestpricetest.application.services;

import com.qs.highestpricetest.domain.model.PriceDto;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@AllArgsConstructor
public class PriceCommand {

    public Mono<PriceDto> find(Integer brandID, Integer productID, LocalDateTime purchaseDay) {
        return Mono.empty();
    }
}
