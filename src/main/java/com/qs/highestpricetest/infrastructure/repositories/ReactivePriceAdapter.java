package com.qs.highestpricetest.infrastructure.repositories;

import com.qs.highestpricetest.domain.model.PriceDto;
import com.qs.highestpricetest.domain.port.out.PriceRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class ReactivePriceAdapter implements PriceRepositoryPort {


    @Override
    public Mono<PriceDto> findHighestPrice(Integer brandID, Integer productID, LocalDateTime purchaseDay) {
        return Mono.empty();
    }
}
