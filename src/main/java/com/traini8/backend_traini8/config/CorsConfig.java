package com.traini8.backend_traini8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // Allowed origins - Add your frontend URLs here
        config.setAllowedOrigins(List.of("http://localhost:63342", "http://localhost:5500"));

        // Allowed HTTP methods
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Allow all headers
        config.setAllowedHeaders(List.of("*"));

        // Allow credentials (only required if sending cookies or authentication headers)
        config.setAllowCredentials(true);

        // Cache the CORS preflight response for 1 hour
        config.setMaxAge(3600L);

        // Apply CORS settings to all endpoints
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
