package com.globalaccelerex.planninghours.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class PlanningHoursConfiguration {

    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        return restTemplate;
    }
}
