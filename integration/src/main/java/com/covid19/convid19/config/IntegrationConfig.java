package com.covid19.convid19.config;

import com.covid19.convid19.properties.IntegrationProperties;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Consumer;

@Configuration
@AllArgsConstructor
public class IntegrationConfig {
    private IntegrationProperties integrationProperties;

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

}
