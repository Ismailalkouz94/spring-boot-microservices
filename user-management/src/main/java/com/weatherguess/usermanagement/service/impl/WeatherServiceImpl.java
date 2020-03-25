package com.weatherguess.usermanagement.service.impl;

import com.weatherguess.usermanagement.dao.UsersRepository;
import com.weatherguess.usermanagement.dao.WeatherRepository;
import com.weatherguess.usermanagement.model.Weather;
import com.weatherguess.usermanagement.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Override
    public Weather save(Weather weather) {
        return weatherRepository.save(weather);
    }
}
