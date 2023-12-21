package com.qs.highestpricetest.infrastructure.adapter.in;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDateTime;

import static com.qs.highestpricetest.util.Commons.formatter;

@SpringBootTest
@AutoConfigureWebTestClient
public class PriceControllerTest {

    @Autowired
    private WebTestClient client;

    @Test
    void getApi() {
        Integer brandId = 1;
        Integer productId = 35455;
        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-14-10.00.00",formatter);
        makeGetRequest(brandId, productId, purchaseDay)
                //assert
                .expectStatus().isOk();
    }
 @Test
    void getApiNotFound() {
        Integer brandId = 1;
        Integer productId = 35455;
     LocalDateTime purchaseDay = LocalDateTime.now();
        makeGetRequest(brandId, productId, purchaseDay)
                //assert
                .expectStatus().isNotFound();
    }

    private WebTestClient.ResponseSpec makeGetRequest(Integer brandId, Integer productId, LocalDateTime purchaseDay) {

        return client.get().uri(String.format("/api/v1/price?brandID=%s&productID=%s&purchaseDay=%s", brandId, productId, purchaseDay.format(formatter)))
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
    }

}
