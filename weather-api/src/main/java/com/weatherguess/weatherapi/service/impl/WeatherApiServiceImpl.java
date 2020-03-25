package com.weatherguess.weatherapi.service.impl;

import com.weatherguess.weatherapi.exception.CustomException;
import com.weatherguess.weatherapi.model.Users;
import com.weatherguess.weatherapi.model.WeatherResponse;
import com.weatherguess.weatherapi.service.UserService;
import com.weatherguess.weatherapi.service.WeatherApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.json.JSONObject;

import java.util.Arrays;

@Service
public class WeatherApiServiceImpl implements WeatherApiService {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${weatherapi.url}")
    private String weatherApiUrl;

    @Value("${api.key}")
    private String apiKey;

    @Override
    public WeatherResponse getWeatherApi(WeatherResponse weather) {

        Users users= userService.findUser(weather.getUserName());
        if (users==null){
            throw new CustomException("User Not Found");
        }

        String realTemp = callWeatherApi(weather.getCityName());
        if(weather.getGuessTemp().equals(realTemp)){
            weather.setCorrect(true);
        }else {
            weather.setCorrect(false);
        }
        weather.setRealTemp(realTemp);

        return weather;
    }

    private String callWeatherApi(String city) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String result = restTemplate.exchange(weatherApiUrl + "key=" + apiKey + "&q=" + city, HttpMethod.GET, entity, String.class).getBody();

        JSONObject jsonObject = new JSONObject(result);
        JSONObject queryObject = (JSONObject) jsonObject.get("current");
        return queryObject.get("temp_c").toString();

    }

}
