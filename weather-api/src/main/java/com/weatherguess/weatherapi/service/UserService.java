package com.weatherguess.weatherapi.service;

import com.weatherguess.weatherapi.model.Users;
import com.weatherguess.weatherapi.model.Weather;
import com.weatherguess.weatherapi.model.WeatherResponse;

public interface UserService {

    Users findUser(String name);
    Weather saveWeatherData(WeatherResponse weather);

}
