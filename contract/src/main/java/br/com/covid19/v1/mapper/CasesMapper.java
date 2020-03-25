package br.com.covid19.v1.mapper;

import br.com.covid19.model.CasesOutput;
import br.com.covid19.v1.model.CasesResponse;
import io.netty.util.internal.ObjectUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CasesMapper {

    public static CasesResponse mapToCasesResponse(CasesOutput casesOutput){
        return ObjectUtils.isEmpty(casesOutput) ? null : CasesResponse.builder()
                .areas(mapToCasesResponseList(casesOutput.getAreas()))
                .displayName(casesOutput.getDisplayName())
                .id(casesOutput.getId())
                .lastUpdated(casesOutput.getLastUpdated())
                .totalConfirmed(casesOutput.getTotalConfirmed())
                .totalDeaths(casesOutput.getTotalDeaths())
                .totalRecovered(casesOutput.getTotalRecovered())
                .build();
    }

    private static List<CasesResponse> mapToCasesResponseList(List<CasesOutput> casesOutputList){
        return casesOutputList.stream().map(casesOutput -> mapFromCasesOutput(casesOutput)).collect(Collectors.toList());
    }

    public static CasesResponse mapFromCasesOutput(CasesOutput casesOutput){
        return ObjectUtils.isEmpty(casesOutput) ? null : CasesResponse.builder()
                .displayName(casesOutput.getDisplayName())
                .id(casesOutput.getId())
                .lastUpdated(casesOutput.getLastUpdated())
                .totalConfirmed(casesOutput.getTotalConfirmed())
                .totalDeaths(casesOutput.getTotalDeaths())
                .totalRecovered(casesOutput.getTotalRecovered())
                .build();
    }
}
