package br.com.covid19.service;

import br.com.covid19.model.CasesOutput;
import br.com.covid19.properties.IntegrationProperties;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.net.URI;

@Service
@AllArgsConstructor
public class IntegrationService {
    private WebClient webClient;
    private IntegrationProperties integrationProperties;

    public Flux<CasesOutput> findAllCases(){
        return WebClient.builder()
                .build()
                .get()
                .uri(getUri())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CasesOutput.class);

    }

    private URI getUri(){
        return URI.create(integrationProperties.getUrlApiDataBase());
    }

}
