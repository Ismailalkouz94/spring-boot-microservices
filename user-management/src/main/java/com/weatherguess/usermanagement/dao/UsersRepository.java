package com.weatherguess.usermanagement.dao;

import com.weatherguess.usermanagement.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByName(String name);
}
