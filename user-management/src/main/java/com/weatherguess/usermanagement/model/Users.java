package com.weatherguess.usermanagement.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@ToString
@EqualsAndHashCode
@Entity
public class Users {
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @NotEmpty(message = "*Please provide a user name")
    @Column(name = "NAME", unique = true)
    private String name;

    @Email(message = "*Please provide a valid Email")
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "ACIIVE")
    private Boolean active;

}
