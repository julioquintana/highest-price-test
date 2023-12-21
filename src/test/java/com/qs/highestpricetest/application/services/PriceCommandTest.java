package com.qs.highestpricetest.application.services;

import com.qs.highestpricetest.domain.model.PriceDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.time.LocalDateTime;

import static com.qs.highestpricetest.util.Commons.formatter;
import static com.qs.highestpricetest.util.PriceMocks.priceExpectedTest1;
import static com.qs.highestpricetest.util.PriceMocks.priceExpectedTest3;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
class PriceCommandTest {

    @Autowired
    private PriceCommand priceCommand;
    private final Integer productId = 35455;
    private final Integer brandId = 1;

    @Test
    public void validateRequestAt10On14thForProduct35455Brand1() throws IOException {

        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-14-10.00.00",formatter);
        PriceDto expectedResult = priceExpectedTest1();

        StepVerifier
                .create(priceCommand.find(brandId, productId, purchaseDay))
                .consumeNextWith(searchPriceDTO -> {
                    assertThat(searchPriceDTO).isEqualTo(expectedResult);
                })
                .verifyComplete();
    }

    @Test
    public void validateRequestAt16On14thForProduct35455Brand1() throws IOException {

        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-14-16.00.00",formatter);
        PriceDto expectedResult = priceExpectedTest1();

        StepVerifier
                .create(priceCommand.find(brandId, productId, purchaseDay))
                .consumeNextWith(searchPriceDTO -> {
                    assertThat(searchPriceDTO).isEqualTo(expectedResult);
                })
                .verifyComplete();
    }

  @Test
    public void validateRequestAt21On14thForProduct35455Brand1() throws IOException {

        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-14-21.00.00",formatter);
        PriceDto expectedResult = priceExpectedTest1();

        StepVerifier
                .create(priceCommand.find(brandId, productId, purchaseDay))
                .consumeNextWith(searchPriceDTO -> {
                    assertThat(searchPriceDTO).isEqualTo(expectedResult);
                })
                .verifyComplete();
    }

}