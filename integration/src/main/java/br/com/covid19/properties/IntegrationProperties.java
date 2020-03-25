package br.com.covid19.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class IntegrationProperties {
    @Value("url-database")
    private String urlApiDataBase;
}
