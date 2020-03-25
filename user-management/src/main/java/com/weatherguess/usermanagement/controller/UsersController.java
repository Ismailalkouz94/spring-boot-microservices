package com.weatherguess.usermanagement.controller;

import com.weatherguess.usermanagement.model.Users;
import com.weatherguess.usermanagement.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/addUser")
    public Users addUser(@RequestBody Users users) {
        return usersService.save(users);
    }

    @GetMapping("/getUsers/{name}")
    public Users getUsers(@PathVariable String name) {
        return usersService.getUserByName(name);
    }

    @GetMapping("/getUsers")
    public List<Users> getUsers() {
        return usersService.getUsers();
    }
}
