package com.qs.highestpricetest.infrastructure.config;

import com.qs.highestpricetest.application.services.PriceCommand;
import com.qs.highestpricetest.application.usescases.FindPriceUseCaseImpl;
import com.qs.highestpricetest.domain.port.in.FindPriceUseCase;
import com.qs.highestpricetest.domain.port.out.PriceRepositoryPort;
import com.qs.highestpricetest.infrastructure.repositories.ReactivePriceAdapter;
import com.qs.highestpricetest.infrastructure.repositories.ReactivePriceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.qs.highestpricetest")
public class ApplicationConfig {
    @Bean
    public FindPriceUseCase findPriceUseCase(PriceRepositoryPort priceRepositoryPort) {
        return new FindPriceUseCaseImpl(priceRepositoryPort);
    }

    @Bean
    public PriceCommand priceCommand(FindPriceUseCase findPriceUseCase) {
        return new PriceCommand(findPriceUseCase);
    }

    @Bean
    public ReactivePriceAdapter reactivePriceAdapter(ReactivePriceRepository reactivePriceRepository) {
        return new ReactivePriceAdapter(reactivePriceRepository);
    }

}
