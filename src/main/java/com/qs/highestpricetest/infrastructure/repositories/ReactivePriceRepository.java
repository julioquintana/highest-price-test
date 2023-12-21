package com.qs.highestpricetest.infrastructure.repositories;

import com.qs.highestpricetest.infrastructure.entities.PriceEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Repository
public interface ReactivePriceRepository extends ReactiveCrudRepository<PriceEntity, Long> {

    @Query("SELECT * FROM PRICES p "
            + "WHERE p.BRAND_ID = :brandID AND "
            + "p.PRODUCT_ID = :productID AND "
            + "(:purchaseDay >= p.START_DATE AND :purchaseDay <= p.END_DATE) ORDER BY p.PRIORITY DESC "
            + "LIMIT 1;"
    )
    Mono<PriceEntity> findHighestPriceByBrandAndProductAndDate(@Param("brandID") Integer brandID,
                                                               @Param("productID") Integer productID,
                                                               @Param("purchaseDay") LocalDateTime purchaseDay);

}
