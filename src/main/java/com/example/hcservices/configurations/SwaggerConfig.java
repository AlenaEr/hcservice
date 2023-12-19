//package com.example.hcservices.configurations;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
//public class SwaggerConfig {
//
//    public SwaggerConfig() {
//        System.out.println("SwaggerConfig instantiated.");
//    }
//
//    @Bean
//    public Docket api() {
//        System.out.println("SwaggerConfig.api() method executed.");
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.hcservices"))
//                .paths(PathSelectors.any())
//                .build();
//
//        System.out.println("Docket: " + docket);
//        return docket;
//    }
//}
