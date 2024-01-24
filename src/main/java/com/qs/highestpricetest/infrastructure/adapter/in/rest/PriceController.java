package com.qs.highestpricetest.infrastructure.adapter.in.rest;

import com.qs.highestpricetest.application.services.PriceCommand;
import com.qs.highestpricetest.domain.model.PriceDto;
import com.qs.highestpricetest.domain.model.UpdatePriceDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Map;

@Log4j2
@RestController
@AllArgsConstructor
public class PriceController {

    private final PriceCommand priceCommand;

    @GetMapping(path = "/api/v1/price")
    public Mono<PriceDto> findPrice(
            @RequestParam(name = "brandID") @NotNull Integer brandID,
            @RequestParam(name = "productID") @NotNull Integer productID,
            @RequestParam(name = "purchaseDay") @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime purchaseDay) {
        log.info(Map.of("brandID", brandID, "productID", productID, "purchaseDay", purchaseDay));

        var response = priceCommand.find(brandID, productID, purchaseDay);

        return response
                .doOnNext(log::info)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró el recurso")));
    }

    @GetMapping(path = "/api/v1/price/product")
    public Flux<PriceDto> findAllPrice(
            @RequestParam(name = "productID") @NotNull Integer productID) {
        log.info(Map.of("productID", productID));

        var response = priceCommand.findAllById(productID);

        return response
                .doOnNext(log::info)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró el recurso")));
    }

    @PutMapping(path = "/api/v1/price/{id}")
    public Mono<PriceDto> udpate(
            @PathVariable(name = "id") @NotNull Integer id,
            @RequestBody @Valid UpdatePriceDto updatePriceDto
    ) {
        log.info(Map.of("id", id, "payload", updatePriceDto));

        var response = priceCommand.update(id, updatePriceDto);

        return response
                .doOnNext(log::info)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró el recurso")));
    }
}
