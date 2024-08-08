package com.example.weatherfeignclient.client;

import com.example.weatherfeignclient.client.model.WeatherApiResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

@FeignClient(name = "weather")
public interface ExternalWeatherApi {

    @GetMapping
    @CircuitBreaker(name = "weather-breaker"
//            , fallbackMethod = "fallbackGetWeather"
    )
//    @Retry(name="weather-retry")
    WeatherApiResponse getWeather(
            @RequestParam(name = "lon") double longitude,
            @RequestParam(name = "lat") double latitude
    );

    default WeatherApiResponse fallbackGetWeather(
            @RequestParam(name = "lon") double longitude
            ,@RequestParam(name = "lat") double latitude
            , Throwable throwable) {
        return new WeatherApiResponse(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),
                "Fallback weather data for " + longitude+" and "+latitude);
    }
}
