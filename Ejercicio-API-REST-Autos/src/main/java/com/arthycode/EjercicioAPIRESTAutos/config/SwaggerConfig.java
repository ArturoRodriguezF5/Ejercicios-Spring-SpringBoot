package com.arthycode.EjercicioAPIRESTAutos.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
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
                .info(new Info().title("API Doc for API REST AUTOS")
                        .description("API REST for services of Autos repository")
                        .version("1.0")
                        .license(new License().name("MIT").url("http://opensource.org/licenses/")));
    }
}
