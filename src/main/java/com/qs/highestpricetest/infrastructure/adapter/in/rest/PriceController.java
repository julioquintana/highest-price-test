package com.qs.highestpricetest.infrastructure.adapter.in.rest;

import com.qs.highestpricetest.application.services.PriceCommand;
import com.qs.highestpricetest.domain.model.PriceDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class PriceController {

    private final PriceCommand priceCommand;

    @GetMapping(path = "/api/v1/price")
    public Mono<PriceDto> findPrice(
            @RequestParam(name = "brandID") @NotNull Integer brandID,
            @RequestParam(name = "productID") @NotNull Integer productID,
            @RequestParam(name = "purchaseDay") @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime purchaseDay) {
        return priceCommand.find(brandID, productID, purchaseDay);
    }
}
