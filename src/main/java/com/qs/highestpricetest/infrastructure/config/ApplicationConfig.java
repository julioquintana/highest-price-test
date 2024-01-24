package com.qs.highestpricetest.infrastructure.config;

import com.qs.highestpricetest.application.services.PriceCommand;
import com.qs.highestpricetest.application.usescases.FindAllPriceUseCaseImpl;
import com.qs.highestpricetest.application.usescases.FindPriceByIdUseCaseImpl;
import com.qs.highestpricetest.application.usescases.FindPriceUseCaseImpl;
import com.qs.highestpricetest.application.usescases.UpdatePriceUseCaseImpl;
import com.qs.highestpricetest.domain.port.in.FindAllPriceUseCase;
import com.qs.highestpricetest.domain.port.in.FindPriceByIdUseCase;
import com.qs.highestpricetest.domain.port.in.FindPriceUseCase;
import com.qs.highestpricetest.domain.port.in.UpdatePriceUseCase;
import com.qs.highestpricetest.domain.port.out.PriceRepositoryPort;
import com.qs.highestpricetest.domain.port.out.PublishPricePort;
import com.qs.highestpricetest.infrastructure.adapter.out.PublisherMessageAdapter;
import com.qs.highestpricetest.infrastructure.publisher.PublisherKafka;
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
    public FindAllPriceUseCase findAllPriceUseCase(PriceRepositoryPort priceRepositoryPort) {
        return new FindAllPriceUseCaseImpl(priceRepositoryPort);
    }

    @Bean
    public FindPriceByIdUseCaseImpl findPriceByIdUseCase(PriceRepositoryPort priceRepositoryPort) {
        return new FindPriceByIdUseCaseImpl(priceRepositoryPort);
    }

    @Bean
    public PublishPricePort publishPricePort(PublisherKafka publisherKafka) {
        return new PublisherMessageAdapter(publisherKafka);
    }

    @Bean
    public UpdatePriceUseCaseImpl updatePriceUseCase(PriceRepositoryPort priceRepositoryPort, FindPriceByIdUseCase findPriceByIdUseCase, PublishPricePort publishPricePort) {
        return new UpdatePriceUseCaseImpl(priceRepositoryPort, findPriceByIdUseCase, publishPricePort);
    }

    @Bean
    public PriceCommand priceCommand(FindPriceUseCase findPriceUseCase, FindAllPriceUseCase findAllPriceUseCase, UpdatePriceUseCase updatePriceUseCase) {
        return new PriceCommand(findPriceUseCase, findAllPriceUseCase, updatePriceUseCase);
    }

    @Bean
    public ReactivePriceAdapter reactivePriceAdapter(ReactivePriceRepository reactivePriceRepository) {
        return new ReactivePriceAdapter(reactivePriceRepository);
    }

}
