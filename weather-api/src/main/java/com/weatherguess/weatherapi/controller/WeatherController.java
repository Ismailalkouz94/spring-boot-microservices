package com.weatherguess.weatherapi.controller;

import com.weatherguess.weatherapi.model.Weather;
import com.weatherguess.weatherapi.model.WeatherResponse;
import com.weatherguess.weatherapi.service.UserService;
import com.weatherguess.weatherapi.service.WeatherApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherApiService weatherApiService;

    @Autowired
    private UserService userService;

    @PostMapping("/getWeather")
    public WeatherResponse getUsers(@RequestBody WeatherResponse weather) {
        return weatherApiService.getWeatherApi(weather);
    }

    @PostMapping("/save")
    public Weather save(@RequestBody WeatherResponse weather) {
        return userService.saveWeatherData(weather);
    }

}
