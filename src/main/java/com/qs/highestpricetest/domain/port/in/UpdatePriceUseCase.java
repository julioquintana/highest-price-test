package com.qs.highestpricetest.domain.port.in;

import com.qs.highestpricetest.domain.model.PriceDto;
import com.qs.highestpricetest.domain.model.UpdatePriceDto;
import reactor.core.publisher.Mono;

public interface UpdatePriceUseCase {
    Mono<PriceDto> update(Integer id, UpdatePriceDto updatePriceDto);

}
