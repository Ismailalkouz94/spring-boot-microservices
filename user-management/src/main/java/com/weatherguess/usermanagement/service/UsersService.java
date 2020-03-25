package com.weatherguess.usermanagement.service;

import com.weatherguess.usermanagement.model.Users;

import java.util.List;

public interface UsersService {
    List<Users> getUsers();
    Users getUserByName(String name);
    Users save (Users users);

}
