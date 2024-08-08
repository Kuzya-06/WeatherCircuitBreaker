package com.example.weatherfeignclient.repository;

import com.example.weatherfeignclient.model.TemperatureType;
import com.example.weatherfeignclient.model.WeatherModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Random;

@Component
public class WeatherRepository {
    Random random = new Random();

    public Optional<WeatherModel> getWeather(
            final Double longitude
            , final Double latitude
            , final LocalDateTime date) {

        if (longitude > 20d && latitude > 20d) {
            return Optional.of(new WeatherModel(
                    date.truncatedTo(ChronoUnit.HOURS)
                    , random.nextDouble(30)
                    , TemperatureType.F));
        } else {
            return Optional.empty();
        }
    }
}
