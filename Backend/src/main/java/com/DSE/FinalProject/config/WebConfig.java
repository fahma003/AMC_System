package com.DSE.FinalProject.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allow cross-origin requests to all endpoints
                .allowedOrigins("http://localhost:3000")  // Allow only from React frontend (adjust this if your frontend URL changes)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allowed methods
                .allowedHeaders("*"); // Allow all headers
                // .allowCredentials(true);  // Allow credentials (e.g., cookies, authorization headers)
    }
}
