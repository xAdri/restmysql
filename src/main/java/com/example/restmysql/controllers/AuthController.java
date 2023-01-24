package com.example.restmysql.controllers;

import com.example.restmysql.exceptions.RequestException;
import com.example.restmysql.models.UserModel;
import com.example.restmysql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    // TODO: ask david to create users without 403 status
    @PostMapping(path = "/register",consumes = {"application/json"})
    public UserModel postUser(@RequestBody UserModel user) {
        if (user.getEmail().equals("") || user.getEmail() == null) {
            throw new RequestException("Email is required", HttpStatus.BAD_REQUEST);
        }
        return this.userService.postUser(user);
    }
}
