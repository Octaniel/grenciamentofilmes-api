package com.octa.grenciamentofilmesapi;

import com.octa.grenciamentofilmesapi.config.property.SpringApiProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SpringApiProperty.class)
public class GrenciamentofilmesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrenciamentofilmesApiApplication.class, args);
    }

}
