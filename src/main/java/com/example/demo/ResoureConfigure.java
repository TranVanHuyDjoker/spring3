package com.example.demo;
//uploadfie
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResoureConfigure implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("uploads/**")
                .addResourceLocations("file:C:/Users/nhattam/Desktop/spring_upl/" );
    }
}
