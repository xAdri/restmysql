package com.example.restmysql.controllers;

import com.example.restmysql.dto.UserDTO;
import com.example.restmysql.exceptions.RequestException;
import com.example.restmysql.exceptions.UserNotFoundException;
import com.example.restmysql.mappers.UserMapper;
import com.example.restmysql.models.UserModel;
import com.example.restmysql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<ArrayList<UserDTO>> listUsers(
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

        return new ResponseEntity<>(UserMapper.toDtoArrayList(users), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> retrieveUserById(@PathVariable("id") Long id) {
        UserModel user = userService.retrieveById(id).orElseThrow(() -> new UserNotFoundException(id));
        return new ResponseEntity<>(UserMapper.toDto(user), HttpStatus.OK);
    }

    @GetMapping(path = "/me")
    public ResponseEntity<UserDTO> retrieveUserLogged(Authentication auth) {
        String email = auth.getPrincipal().toString();
        Optional<UserModel> user = userService.retrieveByEmail(email);
        return new ResponseEntity<>(UserMapper.toDto(user.orElse(new UserModel())), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        if (!this.userService.deleteUser(id)) {
            throw new UserNotFoundException(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
