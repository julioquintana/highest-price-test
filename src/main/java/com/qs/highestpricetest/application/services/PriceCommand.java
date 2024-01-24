package com.qs.highestpricetest.application.services;

import com.qs.highestpricetest.domain.model.PriceDto;
import com.qs.highestpricetest.domain.port.in.FindAllPriceUseCase;
import com.qs.highestpricetest.domain.port.in.FindPriceUseCase;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@AllArgsConstructor
public class PriceCommand {
    private final FindPriceUseCase findPriceUseCase;
    private final FindAllPriceUseCase findAllPriceUseCase;

    public Mono<PriceDto> find(Integer brandID, Integer productID, LocalDateTime purchaseDay) {
        return findPriceUseCase.find(brandID, productID, purchaseDay);
    }
    public Flux<PriceDto> findAllById(Integer productID) {
        return findAllPriceUseCase.findAllById(productID);
    }
}
