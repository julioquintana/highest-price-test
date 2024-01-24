package com.qs.highestpricetest.infrastructure.adapter.in;

import com.qs.highestpricetest.domain.model.PriceDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.qs.highestpricetest.util.Commons.formatter;
import static com.qs.highestpricetest.util.PriceMocks.*;

@SpringBootTest
@AutoConfigureWebTestClient
public class PriceControllerTest {

    @Autowired
    private WebTestClient client;

    @Test
    void getApi() {
        Integer brandId = 1;
        Integer productId = 35455;
        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-14-10.00.00", formatter);
        makeGetRequest(brandId, productId, purchaseDay)
                //assert
                .expectStatus().isOk();
    }
    @Test
    @DisplayName("end-to-end Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void endToEndTestRequestHour10Day14Product35455ZaraBrandExpectedPriceList1() throws IOException {
        Integer brandId = 1;
        Integer productId = 35455;
        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-14-10.00.00", formatter);
        makeGetRequest(brandId, productId, purchaseDay)
                //assert
                .expectStatus().isOk()
                .expectBody(PriceDto.class)
                .isEqualTo(price1Expected());
    }
    @Test
    @DisplayName("end-to-end Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void endToEndTestRequestHour16Day14Product35455ZaraBrandExpectedPriceList2() throws IOException {
        Integer brandId = 1;
        Integer productId = 35455;
        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-14-16.00.00", formatter);
        makeGetRequest(brandId, productId, purchaseDay)
                //assert
                .expectStatus().isOk()
                .expectBody(PriceDto.class)
                .isEqualTo(price2Expected());
    }
    @Test
    @DisplayName("end-to-end Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void endToEndTestRequestHour21Day14Product35455ZaraBrandExpectedPriceList1() throws IOException {
        Integer brandId = 1;
        Integer productId = 35455;
        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-14-21.00.00", formatter);
        makeGetRequest(brandId, productId, purchaseDay)
                //assert
                .expectStatus().isOk()
                .expectBody(PriceDto.class)
                .isEqualTo(price1Expected());
    }
    @Test
    @DisplayName("end-to-end Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    void endToEndTestRequestHour10Day15Product35455ZaraBrandExpectedPriceList3() throws IOException {
        Integer brandId = 1;
        Integer productId = 35455;
        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-15-10.00.00", formatter);
        makeGetRequest(brandId, productId, purchaseDay)
                //assert
                .expectStatus().isOk()
                .expectBody(PriceDto.class)
                .isEqualTo(price3Expected());
    }
    @Test
    @DisplayName("end-to-end Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    void endToEndTestRequestHour21Day16Product35455ZaraBrandExpectedPriceList4() throws IOException {
        Integer brandId = 1;
        Integer productId = 35455;
        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-16-21.00.00", formatter);
        makeGetRequest(brandId, productId, purchaseDay)
                //assert
                .expectStatus().isOk()
                .expectBody(PriceDto.class)
                .isEqualTo(price4Expected());
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

    @Test
    void getApiBadRequest() {
        Integer brandId = 1;
        Integer productId = 35455;
        LocalDateTime purchaseDay = LocalDateTime.now();
        makeGetRequestWithBadRequest(brandId, productId, purchaseDay)
                //assert
                .expectStatus().isBadRequest();
    }
    @Test
    void getApiBadRequestWithMethodArgumentNotValidException() {
        Integer brandId = 1;
        Integer productId = 35455;
        makeGetRequestWithMethodArgumentNotValidException(brandId, productId)
                //assert
                .expectStatus().isBadRequest();
    }



    private WebTestClient.ResponseSpec makeGetRequestWithMethodArgumentNotValidException(Integer brandId, Integer productId) {
        return client.get().uri(String.format("/api/v1/price?brandID=%s&productID=%s", brandId, productId))
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
    }
private WebTestClient.ResponseSpec makeGetRequestWithBadRequest(Integer brandId, Integer productId, LocalDateTime purchaseDay) {
        final String format = "yyyy-MM-dd-HH.mm-ss";
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return client.get().uri(String.format("/api/v1/price?brandID=%s&productID=%s&purchaseDay=%s", brandId, productId, purchaseDay.format(formatter)))
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
    }

    private WebTestClient.ResponseSpec makeGetRequest(Integer brandId, Integer productId, LocalDateTime purchaseDay) {

        return client.get().uri(String.format("/api/v1/price?brandID=%s&productID=%s&purchaseDay=%s", brandId, productId, purchaseDay.format(formatter)))
                .accept(MediaType.APPLICATION_JSON)
                .exchange();
    }

}
