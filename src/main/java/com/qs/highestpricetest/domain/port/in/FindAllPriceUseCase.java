package com.qs.highestpricetest.domain.port.in;

import com.qs.highestpricetest.domain.model.PriceDto;
import reactor.core.publisher.Flux;

public interface FindAllPriceUseCase {
    Flux<PriceDto> findAllById(Integer productID);

}
