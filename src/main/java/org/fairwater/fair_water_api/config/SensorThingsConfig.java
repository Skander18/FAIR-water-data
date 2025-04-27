package org.fairwater.fair_water_api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SensorThingsConfig {

    @Value("${ogc.sensorthings.base-url:/api/v1}")
    private String baseUrl;

    @Bean
    String sensorThingsBaseUrl() {
        return baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
    }
}