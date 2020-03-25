package com.weatherguess.usermanagement.service.impl;

import com.weatherguess.usermanagement.dao.UsersRepository;
import com.weatherguess.usermanagement.model.Users;
import com.weatherguess.usermanagement.service.UsersService;
import com.weatherguess.usermanagement.utils.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUserByName(String name) {
        return usersRepository.findByName(name);
    }

    @Override
    public Users save(Users users) {
        users = usersRepository.save(users);
        if (users != null) {
            try {
                SendEmail.send(users.getEmail(), "hello welcome to weather guessing game");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return users;
    }
}
