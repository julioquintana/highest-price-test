package com.qs.highestpricetest.infrastructure.repositories;

import com.qs.highestpricetest.domain.model.PriceDto;
import com.qs.highestpricetest.domain.port.out.PriceRepositoryPort;
import com.qs.highestpricetest.infrastructure.entities.PriceEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class ReactivePriceAdapter implements PriceRepositoryPort {

    private final ReactivePriceRepository reactivePriceRepository;

    @Override
    public Mono<PriceDto> findHighestPrice(Integer brandID, Integer productID, LocalDateTime purchaseDay) {
        return reactivePriceRepository.findHighestPriceByBrandAndProductAndDate(brandID, productID, purchaseDay)
                .map(PriceEntity::toDomainModel);
    }

    @Override
    public Flux<PriceDto> findAllById(Integer productID) {
        return reactivePriceRepository.findAllById(productID)
                .map(PriceEntity::toDomainModel);
    }
}
