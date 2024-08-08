package com.example.weatherrespo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(path = "/api/weather"
//        , produces = MediaType.APPLICATION_JSON_VALUE
)
public class WeatherRespoController {
    private static int count = 0;

    private record WeatherResponse(LocalDateTime date, String value) {
    }

    @GetMapping
    ResponseEntity<WeatherResponse> getWeather(
            @RequestParam("lon") double longitude,
            @RequestParam("lat") double latitude) throws InterruptedException {
        System.out.println(LocalTime.now() + " call method - " + count++);
//        TimeUnit.SECONDS.sleep(5L);

        return ResponseEntity.ok(new WeatherResponse(
                LocalDateTime.now()
                , new Random().nextInt(40) + " C")
        );

//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
