package com.platzi.market.web.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    //@Bean
    /*public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.platzi.market.web.controller"))
                .build();
    }*/

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info().title("API DOC")
                        .description("Consumer API")
                        .version("v1.5.5")
                        .termsOfService("https://www.mywebsite.com/")
                );
    }
}
