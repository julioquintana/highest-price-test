package com.qs.highestpricetest.infrastructure.config;

import com.qs.highestpricetest.application.services.PriceCommand;
import com.qs.highestpricetest.application.usescases.FindPriceUseCaseImpl;
import com.qs.highestpricetest.domain.port.in.FindPriceUseCase;
import com.qs.highestpricetest.infrastructure.repositories.ReactivePriceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.qs.highestpricetest.infrastructure.repositories")
public class ApplicationConfig {

    @Bean
    public FindPriceUseCase findPriceUseCase() {
        return new FindPriceUseCaseImpl();
    }

    @Bean
    public PriceCommand priceCommand() {
        return new PriceCommand();
    }

    @Bean
    public ReactivePriceAdapter reactivePriceAdapter() {
        return new ReactivePriceAdapter();
    }
}
