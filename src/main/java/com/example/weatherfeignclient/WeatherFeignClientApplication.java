package com.example.weatherfeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WeatherFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherFeignClientApplication.class, args);
    }

}
