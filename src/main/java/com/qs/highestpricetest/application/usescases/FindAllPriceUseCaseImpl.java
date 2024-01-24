package com.qs.highestpricetest.application.usescases;

import com.qs.highestpricetest.application.exception.NotFoundException;
import com.qs.highestpricetest.domain.model.PriceDto;
import com.qs.highestpricetest.domain.port.in.FindAllPriceUseCase;
import com.qs.highestpricetest.domain.port.out.PriceRepositoryPort;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class FindAllPriceUseCaseImpl implements FindAllPriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;

    @Override
    public Flux<PriceDto> findAllById(Integer productID) {
        return priceRepositoryPort.findAllById(productID)
                .switchIfEmpty(Mono.error(new NotFoundException("Product doesnt exit.")));
    }
}
