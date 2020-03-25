package com.weatherguess.weatherapi.service;

import com.weatherguess.weatherapi.model.WeatherResponse;

public interface WeatherApiService {

    WeatherResponse getWeatherApi(WeatherResponse weather);
}
