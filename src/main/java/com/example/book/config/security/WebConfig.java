//package com.example.book.config.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")  // Allow all endpoints
//                .allowedOrigins("*")  // Allow all origins
//                .allowedMethods("*")  // Allow all HTTP methods (GET, POST, PUT, DELETE, etc.)
//                .allowedHeaders("*")  // Allow all headers
//                .allowCredentials(true);  // Allow credentials like cookies
//    }
//}
