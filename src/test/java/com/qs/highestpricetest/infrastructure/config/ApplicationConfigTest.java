package com.qs.highestpricetest.infrastructure.config;

import com.qs.highestpricetest.application.services.PriceCommand;
import com.qs.highestpricetest.domain.port.in.FindPriceUseCase;
import com.qs.highestpricetest.infrastructure.repositories.ReactivePriceAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = ApplicationConfig.class)
class ApplicationConfigTest {

    @Autowired
    private FindPriceUseCase findPriceUseCase;

    @Autowired
    private PriceCommand priceCommand;

    @Autowired
    private ReactivePriceAdapter reactivePriceAdapter;

    @Test
    void testFindPriceUseCase() {
        assertNotNull(findPriceUseCase);
    }

    @Test
    void testPriceCommand() {
        assertNotNull(priceCommand);
    }

    @Test
    void testReactivePriceAdapter() {
        assertNotNull(reactivePriceAdapter);
    }
}
