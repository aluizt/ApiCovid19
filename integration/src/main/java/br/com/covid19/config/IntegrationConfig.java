package br.com.covid19.config;

import br.com.covid19.properties.IntegrationProperties;
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
        return WebClient.builder()
                .baseUrl(integrationProperties.getUrlApiDataBase())
                .defaultHeaders(headers())
                .build();
    }
    private Consumer<HttpHeaders> headers() {
        return httpHeaders -> {
            httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        };
    }
}
