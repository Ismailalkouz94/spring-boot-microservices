package com.weatherguess.weatherapi.service.impl;

import com.weatherguess.weatherapi.model.Users;
import com.weatherguess.weatherapi.model.Weather;
import com.weatherguess.weatherapi.model.WeatherResponse;
import com.weatherguess.weatherapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.managemnt.url}")
    private String userManagemntUrl;

    @Override
    public Users findUser(String name) {

        RestTemplate restTemplate = new RestTemplate();
        Users users = restTemplate.getForObject(userManagemntUrl + "users/getUsers/" + name, Users.class);
        return users;
    }

    @Override
    public Weather saveWeatherData(WeatherResponse weatherResponse) {

        Users users = userService.findUser(weatherResponse.getUserName());
        Weather weather = new Weather();
        weather.setUsers(users);
        weather.setCityName(weatherResponse.getCityName());
        weather.setRealTemp(weatherResponse.getRealTemp());
        weather.setGuessTemp(weatherResponse.getGuessTemp());
        weather.setCorrect(weatherResponse.isCorrect());

        HttpEntity<Weather> request = new HttpEntity<>(weather);
        Weather weatherResult = restTemplate.postForObject(userManagemntUrl + "result/save/", request, Weather.class);
        return weatherResult;
    }
}
