package com.kamar.bdd_in_action.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * the CORS policy configuration.
 * @author kamar baraka.*/

@Configuration
public class CORSConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /*allow access from all origins*/
        registry.addMapping("/**");
    }
}
