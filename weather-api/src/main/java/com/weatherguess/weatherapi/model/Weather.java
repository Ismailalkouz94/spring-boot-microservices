package com.weatherguess.weatherapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString
@EqualsAndHashCode
public class Weather {

    private Long id;

    private Users users;

    private String cityName;

    private String realTemp;

    private String guessTemp;

    private boolean correct;


}