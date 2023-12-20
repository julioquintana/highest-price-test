package com.qs.highestpricetest.infrastructure.adapter.in.rest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PriceController {
    @GetMapping(path = "/api/v1/price")
    public void findPrice(
            @RequestParam(name = "brandID") Integer brandID,
            @RequestParam(name = "productID") Integer productID,
            @RequestParam(name = "purchaseDay") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime purchaseDay) {
    }
}
