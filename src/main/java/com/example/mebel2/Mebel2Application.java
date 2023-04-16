package com.example.mebel2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Mebel2Application {

    public static void main(String[] args) {
        SpringApplication.run(Mebel2Application.class, args);
    }

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
