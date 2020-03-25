package com.weatherguess.weatherapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class WeatherResponse {

    private String userName;

    private String cityName;

    private String realTemp;

    private String guessTemp;

    private boolean correct;


}
