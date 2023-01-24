package com.example.restmysql.services;

import com.example.restmysql.models.UserModel;

import java.util.ArrayList;
import java.util.Optional;

public interface UserService {

    ArrayList<UserModel> listUsers();

    UserModel postUser(UserModel user);

    Optional<UserModel> retrieveById(Long id);

    ArrayList<UserModel> listByClientGroup(char clientGroup);

    ArrayList<UserModel> listByEmail(String email);

    boolean deleteUser(Long id);

    Optional<UserModel> retrieveByEmail(String email);
}
