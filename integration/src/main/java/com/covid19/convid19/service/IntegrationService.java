package com.covid19.convid19.service;

import com.covid19.convid19.model.CasesOutput;
import com.covid19.convid19.properties.IntegrationProperties;
import io.netty.handler.codec.http2.Http2Exception;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;

@Service
@AllArgsConstructor
public class IntegrationService {
    private WebClient webClient;
    private IntegrationProperties integrationProperties;

    public Mono<CasesOutput> findAllCases(){
//             return webClient
//                    .get()
//                    .uri(getUri())
//                    .accept(MediaType.APPLICATION_JSON)
//                    .retrieve()
//                    .bodyToMono(CasesOutput.class);

//        WebClient webClient = WebClient.create("http://www.bing.com/covid/data?IG=43D819DE3AE5411E8C07972ECAFC23DC");
//        Mono<CasesOutput> result = webClient.get().retrieve().bodyToMono(CasesOutput.class);

        return WebClient.builder()
                .baseUrl("http://www.bing.com/covid/data?IG=43D819DE3AE5411E8C07972ECAFC23DC")
                .build()
                .get()
                .retrieve()
                .bodyToMono(CasesOutput.class);
    }

    private URI getUri(){
        var url = String.format("%s", integrationProperties.getUrlApiDataBase());
        return URI.create(url);
    }

}
