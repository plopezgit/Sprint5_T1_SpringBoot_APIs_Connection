package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n03.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate restTemplate (RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
}
