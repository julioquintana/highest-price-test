package com.qs.highestpricetest.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.qs.highestpricetest.domain.model.PriceDto;

import java.io.IOException;
import java.io.InputStream;

public class PriceMocks {

    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false)
            .registerModule(new JavaTimeModule());


    public static PriceDto priceExpectedTest1() throws IOException {
            InputStream inputStream = PriceMocks.class.getClassLoader().getResourceAsStream("json/priceExpectedTest1.json");

        return mapper.readValue(inputStream, PriceDto.class);
    }
    public static PriceDto priceExpectedTest2() throws IOException {
            InputStream inputStream = PriceMocks.class.getClassLoader().getResourceAsStream("json/priceExpectedTest2.json");

        return mapper.readValue(inputStream, PriceDto.class);
    }
    public static PriceDto priceExpectedTest3() throws IOException {
            InputStream inputStream = PriceMocks.class.getClassLoader().getResourceAsStream("json/priceExpectedTest3.json");

        return mapper.readValue(inputStream, PriceDto.class);
    }
    public static PriceDto priceExpectedTest4() throws IOException {
            InputStream inputStream = PriceMocks.class.getClassLoader().getResourceAsStream("json/priceExpectedTest4.json");

        return mapper.readValue(inputStream, PriceDto.class);
    }
    public static PriceDto priceExpectedTest5() throws IOException {
            InputStream inputStream = PriceMocks.class.getClassLoader().getResourceAsStream("json/priceExpectedTest5.json");

        return mapper.readValue(inputStream, PriceDto.class);
    }

}
