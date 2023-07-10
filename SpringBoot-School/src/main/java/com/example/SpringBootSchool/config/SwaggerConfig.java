package com.example.SpringBootSchool.config;

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
                .info(new Info()
                        .title("REST API Students")
                        .description("The REST API students methods")
                        .version("1.0")
                        .license(new License()
                                .name("MTI Release")
                                .url("http://MIT license")));

    }


}
