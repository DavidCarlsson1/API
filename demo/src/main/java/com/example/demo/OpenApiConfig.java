package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springdoc.core.GroupedOpenApi;



@Configuration
public class OpenApiConfig {
 
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()          
          .info(new Info()
                  .title("Open communication API created for CSN")
                  .description("To be used by CSN for spreading information to stakeholders through external websites")
                  .version("v1.0")
                  .contact(new Contact()
                          .name("David Carlsson & Mikolaj Wagner")
                          .url("")
                          .email("david.carlsson@csn.se & mikolaj.wagner@csn.se"))
                  .termsOfService("https://www.csn.se/")
                  .license(new License().name("Apache License").url("https://apache.org/licenses/LICENSE-2.0"))
          );
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/public/**")
                .pathsToExclude("/admin/**")
                .build();
    }

    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("admin")
                .pathsToMatch("/admin/**", "/public/**")
                .build();
    }
}