package com.example.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.PathSelectors;  
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

@Configuration
public class SwaggerConfig {
  
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)          
          .apiInfo(apiInfo())
          .select()    
          .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
          .paths(PathSelectors.any())
          .build();
    }

    private ApiInfo apiInfo() {
      return new ApiInfoBuilder()
        .title("Open communication API created by CSN")
        .description("To be used by CSN to spread information to stakeholders through external websites")
        .termsOfServiceUrl("http://javainuse.com")
        .contact(new Contact("David Carlsson", "", "david.carlsson@csn.se"))
        .license("Apache License")
          .licenseUrl("https://apache.org/licenses/LICENSE-2.0")
        .version("1.0")
        .build();
    }
}