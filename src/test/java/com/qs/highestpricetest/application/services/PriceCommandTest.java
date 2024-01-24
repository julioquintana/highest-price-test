package com.qs.highestpricetest.application.services;

import com.qs.highestpricetest.domain.model.PriceDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.time.LocalDateTime;

import static com.qs.highestpricetest.util.Commons.formatter;
import static com.qs.highestpricetest.util.PriceMocks.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
class PriceCommandTest {

    @Autowired
    private PriceCommand priceCommand;
    private final Integer productId = 35455;
    private final Integer brandId = 1;

    @Test
    public void validateRequestAt10On14thForProduct35455Brand1() throws IOException {

        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-14-10.00.00", formatter);
        PriceDto expectedResult = price1Expected();

        validate(purchaseDay, expectedResult);
    }

    @Test
    public void validateRequestAt16On14thForProduct35455Brand1() throws IOException {

        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-14-16.00.00", formatter);
        PriceDto expectedResult = price2Expected();

        validate(purchaseDay, expectedResult);
    }

    @Test
    public void validateRequestAt21On14thForProduct35455Brand1() throws IOException {

        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-14-21.00.00", formatter);
        PriceDto expectedResult = price1Expected();

        validate(purchaseDay, expectedResult);
    }

    @Test
    public void validateRequestAt10On15thForProduct35455Brand1() throws IOException {

        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-15-10.00.00", formatter);
        PriceDto expectedResult = price3Expected();

        validate(purchaseDay, expectedResult);
    }

    @Test
    public void validateRequestAt21On16thForProduct35455Brand1() throws IOException {

        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-16-21.00.00", formatter);
        PriceDto expectedResult = price4Expected();

        validate(purchaseDay, expectedResult);
    }

    @Test
    public void validateRequestAt23On16thForProduct35455Brand1() throws IOException {

        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-16-23.00.00", formatter);
        PriceDto expectedResult = price4Expected();

        validate(purchaseDay, expectedResult);
    }

    @Test
    public void validateRequestAt00On14thForProduct35455Brand1() throws IOException {

        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-14-00.00.00", formatter);
        PriceDto expectedResult = price1Expected();

        validate(purchaseDay, expectedResult);
    }

    @Test
    public void validateRequestAt1830n14thForProduct35455Brand1() throws IOException {

        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-14-18.30.00", formatter);
        PriceDto expectedResult = price2Expected();

        validate(purchaseDay, expectedResult);
    }
    @Test
    public void validateRequestAt183001n14thForProduct35455Brand1() throws IOException {

        LocalDateTime purchaseDay = LocalDateTime.parse("2020-06-14-18.30.01", formatter);
        PriceDto expectedResult = price1Expected();

        validate(purchaseDay, expectedResult);
    }

    @Test
    public void validateRequestAt235959On31thForProduct35455Brand1() throws IOException {

        LocalDateTime purchaseDay = LocalDateTime.parse("2020-12-31-23.59.59", formatter);
        PriceDto expectedResult = price4Expected();

        validate(purchaseDay, expectedResult);
    }

    private void validate(LocalDateTime purchaseDay, PriceDto expectedResult) {
        StepVerifier
                .create(priceCommand.find(brandId, productId, purchaseDay))
                .consumeNextWith(searchPriceDTO -> {
                    assertThat(searchPriceDTO).isEqualTo(expectedResult);
                })
                .verifyComplete();
    }
}