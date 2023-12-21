package com.qs.highestpricetest.application.usescases;

import com.qs.highestpricetest.domain.model.PriceDto;
import com.qs.highestpricetest.domain.port.in.FindPriceUseCase;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@AllArgsConstructor
public class FindPriceUseCaseImpl implements FindPriceUseCase {


    @Override
    public Mono<PriceDto> find(Integer brandID, Integer productID, LocalDateTime purchaseDay) {
        return Mono.empty();
    }
}
