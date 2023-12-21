package com.qs.highestpricetest.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {
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
}
