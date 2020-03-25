package com.weatherguess.weatherapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@Data
@ToString
@EqualsAndHashCode
public class Users {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private Boolean active;

}
