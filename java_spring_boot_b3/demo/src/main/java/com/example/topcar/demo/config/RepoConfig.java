package com.example.topcar.demo.config;

import com.example.topcar.demo.repository.CarDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepoConfig {

    @Bean
    public CarDao carDao(){
        return new CarDao("car.csv");
    }
}
