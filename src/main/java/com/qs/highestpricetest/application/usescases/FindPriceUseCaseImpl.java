package com.qs.highestpricetest.application.usescases;

import com.qs.highestpricetest.application.exception.NotFoundException;
import com.qs.highestpricetest.domain.model.PriceDto;
import com.qs.highestpricetest.domain.port.in.FindPriceUseCase;
import com.qs.highestpricetest.domain.port.out.PriceRepositoryPort;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@AllArgsConstructor
public class FindPriceUseCaseImpl implements FindPriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;

    @Override
    public Mono<PriceDto> find(Integer brandID, Integer productID, LocalDateTime purchaseDay) {
        return priceRepositoryPort.findHighestPrice(brandID, productID, purchaseDay)
                .switchIfEmpty(Mono.error(new NotFoundException("Price doesnt exit.")));
    }
}
