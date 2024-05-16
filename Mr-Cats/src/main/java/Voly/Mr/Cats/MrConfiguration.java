package Voly.Mr.Cats;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MrConfiguration {
    @Bean
    public RestTemplate mrRestTemplate() {
        return new RestTemplateBuilder().build();
    }
}
