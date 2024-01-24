package com.qs.highestpricetest.domain.port.in;

import com.qs.highestpricetest.domain.model.PriceDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public interface FindAllPriceUseCase {
    Flux<PriceDto> findAllById(Integer productID);

}
