package com.qs.highestpricetest.application.services;

import com.qs.highestpricetest.domain.port.in.FindPriceUseCase;
import com.qs.highestpricetest.domain.model.PriceDto;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@AllArgsConstructor
public class PriceCommand {
    private final FindPriceUseCase findPriceUseCase;

    public Mono<PriceDto> find(Integer brandID, Integer productID, LocalDateTime purchaseDay) {
        return findPriceUseCase.find(brandID, productID, purchaseDay);
    }
}
