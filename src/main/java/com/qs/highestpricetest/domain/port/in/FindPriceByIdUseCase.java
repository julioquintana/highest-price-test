package com.qs.highestpricetest.domain.port.in;

import com.qs.highestpricetest.domain.model.PriceDto;
import reactor.core.publisher.Mono;

public interface FindPriceByIdUseCase {
    Mono<PriceDto> findPriceById(Integer id);

}