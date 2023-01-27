package com.example.restmysql.controllers;

import com.example.restmysql.dto.UserDTO;
import com.example.restmysql.exceptions.RequestException;
import com.example.restmysql.mappers.UserMapper;
import com.example.restmysql.models.UserModel;
import com.example.restmysql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/register", consumes = {"application/json"})
    public ResponseEntity<UserDTO> postUser(@RequestBody UserModel user) {
        if (user.getEmail().equals("") || user.getEmail() == null) {
            // TODO: Add new validators
            throw new RequestException("Email is required", HttpStatus.BAD_REQUEST);
        }
        UserModel new_user = userService.postUser(user);
        return new ResponseEntity<>(UserMapper.toDto(new_user), HttpStatus.CREATED);
    }
}
