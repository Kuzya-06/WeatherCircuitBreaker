package com.example.weatherfeignclient.controller;

import com.example.weatherfeignclient.facade.WeatherFacade;
import com.example.weatherfeignclient.model.WeatherRequest;
import com.example.weatherfeignclient.model.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherFacade weatherFacade;


    @PostMapping
    public WeatherResponse getWeather(
            @RequestBody final WeatherRequest request) {

        return weatherFacade.getWeather(request);
    }
}
