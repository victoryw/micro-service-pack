package org.victoryw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfiguration {
    //CHECKSTYLE:OFF
    @Bean
    public RestTemplate restTemplate() {
        //CHECKSTYLE:ON
        return new RestTemplate();
    }


}
