package com.weatherguess.usermanagement.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@EqualsAndHashCode
@Entity
public class Weather {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "USER_ID",referencedColumnName = "USER_ID")
    private Users users;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Column(name = "REAL_TEMP")
    private String realTemp;

    @Column(name = "GUESS_TEMP")
    private String guessTemp;

    @Column(name = "CORRECT")
    private boolean correct;


}