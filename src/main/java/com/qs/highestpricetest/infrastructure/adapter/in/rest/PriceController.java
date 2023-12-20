package com.qs.highestpricetest.infrastructure.adapter.in.rest;

import com.qs.highestpricetest.application.services.PriceCommand;
import com.qs.highestpricetest.infrastructure.adapter.in.model.PriceDto;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class PriceController {

    private final PriceCommand priceCommand;
    @GetMapping(path = "/api/v1/price")
    public Flux<PriceDto> findPrice(
            @RequestParam(name = "brandID") Integer brandID,
            @RequestParam(name = "productID") Integer productID,
            @RequestParam(name = "purchaseDay") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime purchaseDay) {

        return priceCommand.find(brandID,productID, purchaseDay);
    }
}
