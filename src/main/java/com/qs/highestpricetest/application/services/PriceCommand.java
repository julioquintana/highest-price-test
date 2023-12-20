package com.qs.highestpricetest.application.services;

import com.qs.highestpricetest.infrastructure.adapter.in.model.PriceDto;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@AllArgsConstructor
public class PriceCommand {

    public Flux<PriceDto> find(Integer brandID, Integer productID, LocalDateTime purchaseDay) {
        return Flux.empty();
    }
}
