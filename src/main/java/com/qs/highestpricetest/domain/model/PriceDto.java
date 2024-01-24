package com.qs.highestpricetest.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.qs.highestpricetest.infrastructure.entities.PriceEntity;
import com.qs.highestpricetest.infrastructure.util.Mapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceDto extends Mapper {
    private Integer id;
    private Long brandID;
    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime startDate;
    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime endDate;
    private Long priceList;
    private Long productID;
    private Long priority;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT, pattern = "#,##0.00")
    private BigDecimal price;
    private String curr;

    @Override
    public String toString() {
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public PriceEntity toEntity() {
        return PriceEntity.builder()
                .id(id)
                .brandID(brandID)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(priceList)
                .productID(productID)
                .priority(priority)
                .price(price)
                .curr(curr)
                .build();
    }
}
