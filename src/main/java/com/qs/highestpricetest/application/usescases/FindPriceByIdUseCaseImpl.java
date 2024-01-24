package com.qs.highestpricetest.application.usescases;

import com.qs.highestpricetest.application.exception.NotFoundException;
import com.qs.highestpricetest.domain.model.PriceDto;
import com.qs.highestpricetest.domain.port.in.FindPriceByIdUseCase;
import com.qs.highestpricetest.domain.port.in.FindPriceUseCase;
import com.qs.highestpricetest.domain.port.out.PriceRepositoryPort;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@AllArgsConstructor
public class FindPriceByIdUseCaseImpl implements FindPriceByIdUseCase {

    private final PriceRepositoryPort priceRepositoryPort;

    @Override
    public Mono<PriceDto> findPriceById(Integer id) {
        return priceRepositoryPort.findPriceById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Price doesnt exit.")));
    }

}
