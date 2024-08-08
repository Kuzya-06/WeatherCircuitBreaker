package com.example.weatherfeignclient.service;

import com.example.weatherfeignclient.model.WeatherModel;
import com.example.weatherfeignclient.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public Optional<WeatherModel> getWeather(
            final Double longitude
            , final Double latitude
            , final LocalDateTime date) {

        Assert.notNull(longitude, "longitude must be a set");
        Assert.notNull(latitude, "latitude must be a set");

        Optional<WeatherModel> weather = weatherRepository.getWeather(
                longitude
                , latitude
                , date == null ? LocalDateTime.now() : date);

        return weather;
    }
}
