package com.smunity.petition.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI getOpenApi() {
        return new OpenAPI().info(getSwaggerInfo());
    }

    private Info getSwaggerInfo() {
        License license = new License();
        license.setName("Copyright (c) 2024 Smunity");

        return new Info()
                .title("Smunity API Document")
                .description("Smunity의 API 문서 입니다.")
                .version("v0.0.1")
                .license(license);
    }
}
