package com.qs.highestpricetest.application.usescases;

import com.qs.highestpricetest.domain.model.PriceDto;
import com.qs.highestpricetest.domain.model.UpdatePriceDto;
import com.qs.highestpricetest.domain.port.in.FindPriceByIdUseCase;
import com.qs.highestpricetest.domain.port.in.UpdatePriceUseCase;
import com.qs.highestpricetest.domain.port.out.PriceRepositoryPort;
import com.qs.highestpricetest.domain.port.out.PublishPricePort;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class UpdatePriceUseCaseImpl implements UpdatePriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;
    private final FindPriceByIdUseCase findPriceByIdUseCase;
    private final PublishPricePort publishPricePort;

    @Override
    public Mono<PriceDto> update(Integer id, UpdatePriceDto updatePriceDto) {
        return findPriceByIdUseCase.findPriceById(id).flatMap(priceDto -> {
            priceDto.setStartDate(updatePriceDto.getStartDate());
            priceDto.setEndDate(updatePriceDto.getEndDate());
            priceDto.setPrice(updatePriceDto.getPrice());
            return priceRepositoryPort.update(priceDto);
        }).flatMap(updatePriceDtoResponse ->
                Mono.zip(Mono.just(updatePriceDtoResponse), publishPricePort.publish(updatePriceDtoResponse))
                .flatMap(tuple -> Mono.just(tuple.getT1())));
    }
}
