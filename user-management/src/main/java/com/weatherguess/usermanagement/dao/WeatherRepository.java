package com.weatherguess.usermanagement.dao;

import com.weatherguess.usermanagement.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
