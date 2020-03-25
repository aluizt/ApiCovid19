package com.covid19.convid19.v1;

import com.covid19.convid19.service.IntegrationService;
import com.covid19.convid19.v1.mapper.CasesMapper;
import com.covid19.convid19.v1.model.CasesResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("v1")
@AllArgsConstructor
public class CasesRestController {

    private IntegrationService integrationService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CasesResponse> findCases() {
        return integrationService.findAllCases().map(CasesMapper::mapToCasesResponse);
    }
}
