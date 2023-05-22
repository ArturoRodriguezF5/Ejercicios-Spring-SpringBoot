package com.arthycode.SpringRestApiHeladeria.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info().title("REST API for Heladeria Exercise")
                        .description("REST API for Heladeria Exercise")
                        .license(new License().url("http://www.heladeria.").name("http://www.heladeria"))
                        .termsOfService("http://www.heladeria."));
    }
}
