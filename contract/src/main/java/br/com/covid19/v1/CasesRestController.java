package br.com.covid19.v1;

import br.com.covid19.service.IntegrationService;
import br.com.covid19.v1.mapper.CasesMapper;
import br.com.covid19.v1.model.CasesResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import reactor.core.publisher.Flux;

@RestController
@RequestMapping("v1")
@AllArgsConstructor
public class CasesRestController {

    private IntegrationService integrationService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Flux<CasesResponse> findCases(){
        return integrationService.findAllCases().map(CasesMapper::mapToCasesResponse);
    }
}
