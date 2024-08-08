package com.example.weatherfeignclient.client.model;

import java.time.LocalDateTime;

public record WeatherApiResponse (LocalDateTime date, String value){
}
