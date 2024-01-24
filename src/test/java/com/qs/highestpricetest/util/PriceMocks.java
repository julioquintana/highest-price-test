package com.qs.highestpricetest.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.qs.highestpricetest.application.exception.ErrorResponse;
import com.qs.highestpricetest.domain.model.PriceDto;

import java.io.IOException;
import java.io.InputStream;

public class PriceMocks {

    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false)
            .registerModule(new JavaTimeModule());


    public static PriceDto price1Expected() throws IOException {
        InputStream inputStream = PriceMocks.class.getClassLoader().getResourceAsStream("json/priceList1.json");

        return mapper.readValue(inputStream, PriceDto.class);
    }

    public static PriceDto price2Expected() throws IOException {
        InputStream inputStream = PriceMocks.class.getClassLoader().getResourceAsStream("json/priceList2.json");

        return mapper.readValue(inputStream, PriceDto.class);
    }

    public static PriceDto price3Expected() throws IOException {
        InputStream inputStream = PriceMocks.class.getClassLoader().getResourceAsStream("json/priceList3.json");

        return mapper.readValue(inputStream, PriceDto.class);
    }

    public static PriceDto price4Expected() throws IOException {
        InputStream inputStream = PriceMocks.class.getClassLoader().getResourceAsStream("json/priceList4.json");

        return mapper.readValue(inputStream, PriceDto.class);
    }

    public static ErrorResponse notFound() throws IOException {
        InputStream inputStream = PriceMocks.class.getClassLoader().getResourceAsStream("json/priceList4.json");

        return mapper.readValue(inputStream, ErrorResponse.class);
    }

}
