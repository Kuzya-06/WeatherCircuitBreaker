package com.example.weatherfeignclient.model;

import java.time.LocalDateTime;

public record WeatherResponse(LocalDateTime date, String temperature) {

    public static WeatherResponse empty() {
        System.out.println("Выполняется WeatherResponse метод empty() !!!");
        return new WeatherResponse(LocalDateTime.now(), " no data found");
    }
}
