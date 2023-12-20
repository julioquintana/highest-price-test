package com.qs.highestpricetest.infrastructure.adapter.in;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebFluxTest
public class PriceControllerTest {

    @Autowired
    private WebTestClient client;

    @Test
    void getApi() {
        Integer brandId = 1;
        Integer productId = 35455;
        LocalDateTime purchaseDay = LocalDateTime.now();
        makeGetRequest(brandId, productId, purchaseDay)
                //assert
                .expectStatus().isOk();
    }

    private WebTestClient.ResponseSpec makeGetRequest(Integer brandId, Integer productId, LocalDateTime purchaseDay) {
        String format = "yyyy-MM-dd-HH.mm.ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

        return client.get().uri(String.format("/api/v1/price?brandID=%s&productID=%s&purchaseDay=%s", brandId, productId, purchaseDay.format(formatter)))
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
    }

}
