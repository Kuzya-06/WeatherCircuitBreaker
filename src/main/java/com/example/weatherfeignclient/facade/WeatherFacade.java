package com.example.weatherfeignclient.facade;

import com.example.weatherfeignclient.client.ExternalWeatherApi;
import com.example.weatherfeignclient.model.WeatherModel;
import com.example.weatherfeignclient.model.WeatherRequest;
import com.example.weatherfeignclient.model.WeatherResponse;
import com.example.weatherfeignclient.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherFacade {

    private final WeatherService weatherService;
    private final ExternalWeatherApi externalWeatherApi;

    public WeatherResponse getWeather(@RequestBody final WeatherRequest request) {

        Optional<WeatherModel> weather = weatherService.getWeather(request.longitude(), request.latitude(), request.date());



        WeatherResponse weatherResponse = weather
                .map(weatherModel -> new WeatherResponse(
                        weatherModel.date(), weatherModel.temperature() + weatherModel.type().name()))
//                .orElse(WeatherResponse.empty());
                .orElse(getExternalWeatherApi(request));

        return weatherResponse;

    }

    private WeatherResponse getExternalWeatherApi(final WeatherRequest request) {
        return Optional.ofNullable(externalWeatherApi.getWeather(request.longitude(), request.latitude()))
                .map(response -> new WeatherResponse(response.date(), response.value()))
                .orElse(WeatherResponse.empty());
    }
}
