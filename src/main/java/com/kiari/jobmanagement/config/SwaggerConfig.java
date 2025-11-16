//package com.kiari.jobmanagement.config;
//
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.security.SecurityRequirement;
//import io.swagger.v3.oas.models.security.SecurityScheme;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SwaggerConfig {
//
//    @Bean
//    public OpenAPI openAPI() {
//
//        return new OpenAPI().info(new Info().title("Job Management").description("API Responsible to manage job opportunities").version("1.0.0"));
////                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
////                .schemaRequirement("jwt_auth", createSecurityScheme());
////                .components(new Components().addSecuritySchemes("Bearer Authentication", createSecurityScheme()));
//    }
//
//    private SecurityScheme createSecurityScheme() {
//        return new SecurityScheme().name("jwt_auth").type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT");
//    }
//}
