package com.qs.highestpricetest.infrastructure.entities;

import com.qs.highestpricetest.domain.model.PriceDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@ToString
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Table("PRICES")
public class PriceEntity {

    // Price identifier.
    @Id
    @Column("ID")
    private Integer id;

    // Brand identifier.
    @Column("BRAND_ID")
    private Long brandID;

    // init Range of dates for which the indicated tariff price applies.
    @Column("START_DATE")
    private LocalDateTime startDate;

    // finish Range of dates for which the indicated tariff price applies.
    @Column("END_DATE")
    private LocalDateTime endDate;

    // Identifier code for the price list.
    @Column("PRICE_LIST")
    private Long priceList;

    // Product identifier code.
    @Column("PRODUCT_ID")
    private Long productID;

    // Price application disambiguator.
    // If two tariffs coincide in a date range,
    // the one with higher priority (higher numerical value) applies.
    @Column("PRIORITY")
    private Long priority;

    // Final sale price.
    @Column("PRICE")
    private BigDecimal price;

    // ISO code of the currency.
    @Column("CURR")
    private String curr;


    public PriceDto toDomainModel() {
        return new PriceDto(getId(),
                getBrandID(),
                getStartDate(),
                getEndDate(),
                getPriceList(),
                getProductID(),
                getPriority(),
                getPrice(),
                getCurr());
    }
}
