package com.example.restmysql.controllers;

import com.example.restmysql.exceptions.RequestException;
import com.example.restmysql.exceptions.UserNotFoundException;
import com.example.restmysql.models.UserModel;
import com.example.restmysql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<ArrayList<UserModel>> listUsers(
            @RequestParam(value = "clientGroup", defaultValue = "\0", required = false) char clientGroup,
            @RequestParam(value = "email", defaultValue = "", required = false) String email
    ) {
        ArrayList<UserModel> users = null;
        if (clientGroup != '\0') {
            users = userService.listByClientGroup(clientGroup);
        }

        if (!email.isEmpty()) {
            users = userService.listByEmail(email);
        }

        // No queryparams return all list of users
        if (clientGroup == '\0' && email.isEmpty()) {
            users = userService.listUsers();
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(consumes = {"application/json"})
    public UserModel postUser(@RequestBody UserModel user) {
        if (user.getEmail().equals("") || user.getEmail() == null) {
            throw new RequestException("Email is required", HttpStatus.BAD_REQUEST);
        }
        return this.userService.postUser(user);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserModel> retrieveUserById(@PathVariable("id") Long id) {
        UserModel user = userService.retrieveById(id).orElseThrow(() -> new UserNotFoundException(id));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        if (!this.userService.deleteUser(id)) {
            throw new UserNotFoundException(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
