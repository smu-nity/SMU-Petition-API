package com.smunity.petition.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI getOpenApi() {
        Server server = new Server().url("/");

        return new OpenAPI()
                .info(getSwaggerInfo())
                .addServersItem(server);
    }

    private Info getSwaggerInfo() {
        License license = new License();
        license.setName("{Application}");

        return new Info()
                .title("Smunity API Document")
                .description("Smunity의 API 문서 입니다.")
                .version("v0.0.1")
                .license(license);
    }
}
