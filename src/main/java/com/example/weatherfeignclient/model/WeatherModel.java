package com.example.weatherfeignclient.model;

import java.time.LocalDateTime;

public record WeatherModel(
        LocalDateTime date
        , Double temperature
        , TemperatureType type
) {
}
