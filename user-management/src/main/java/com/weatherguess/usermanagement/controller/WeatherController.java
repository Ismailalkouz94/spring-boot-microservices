package com.weatherguess.usermanagement.controller;

import com.weatherguess.usermanagement.model.Users;
import com.weatherguess.usermanagement.model.Weather;
import com.weatherguess.usermanagement.service.UsersService;
import com.weatherguess.usermanagement.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @PostMapping("/save")
    public Weather addUser(@RequestBody Weather weather) {
        return weatherService.save(weather);
    }

}
