package com.qs.highestpricetest.infrastructure.util;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "properties.kafka")
public class PropertyValues {
    private String topic;
}
