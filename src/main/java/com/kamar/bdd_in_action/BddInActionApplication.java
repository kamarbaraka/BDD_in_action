package com.kamar.bdd_in_action;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BddInActionApplication {

    public static void main(String[] args) {
        SpringApplication.run(BddInActionApplication.class, args);
    }

    /**
     * create a model mapper bean.
     * @return an instance of the model mapper bean.*/
    @Bean
    public ModelMapper modelMapper(){

        /*create an instance of the model mapper bean and return it.*/
        return new ModelMapper();
    }

    /**
     * overrides the default {@link com.fasterxml.jackson.databind.ObjectMapper}
     * to set the json properties to snake_case.
     * @return {@link ObjectMapper}*/
    /*@Bean
    public ObjectMapper objectMapper(){

         *//*construct an object mapper*//*
        ObjectMapper objectMapper = new ObjectMapper();
        *//*set the json properties to snake case*//*
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        *//*return the configured object mapper*//*
        return objectMapper;
    }*/

}
