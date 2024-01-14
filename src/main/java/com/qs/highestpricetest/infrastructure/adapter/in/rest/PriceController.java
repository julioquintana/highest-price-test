package com.qs.highestpricetest.infrastructure.adapter.in.rest;

import com.qs.highestpricetest.application.services.PriceCommand;
import com.qs.highestpricetest.domain.model.PriceDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
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
}
