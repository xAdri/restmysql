package com.example.restmysql.controllers;

import com.example.restmysql.models.UserModel;
import com.example.restmysql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> listUsers() {
        return userService.listUsers();
    }

    @PostMapping(consumes = {"application/json"})
    public UserModel postUser(@RequestBody UserModel user) {
        return this.userService.postUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> retrieveUserById(@PathVariable("id") Long id) {
        return this.userService.retrieveById(id);
    }

    @GetMapping("/query")
    public ArrayList<UserModel> listUsersByClientGroup(@RequestParam("clientGroup") char clientGroup) {
        return this.userService.listByClientGroup(clientGroup);
    }

    @DeleteMapping(path = "/{id}")
    public Dictionary deleteById(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);
        Dictionary dict = new Hashtable();

        if (!ok) {
            dict.put("Detail", "User with id " + id + " does not exist");
            return dict;
        }

        dict.put("Detail", "Deleted user with id " + id);
        return dict;
    }
}
