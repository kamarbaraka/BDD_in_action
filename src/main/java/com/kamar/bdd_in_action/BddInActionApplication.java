package com.kamar.bdd_in_action;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BddInActionApplication {

    public static void main(String[] args) {
        SpringApplication.run(BddInActionApplication.class, args);
    }

    /**
     * create a model mapper bean.
     * @return an instance of the model mapper bean.*/
    public ModelMapper modelMapper(){

        /*create an instance of the model mapper bean and return it.*/
        return new ModelMapper();
    }

}
