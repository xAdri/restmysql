package com.example.restmysql.services;

import com.example.restmysql.models.UserModel;
import com.example.restmysql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

public interface UserService {

    ArrayList<UserModel> listUsers();

    UserModel postUser(UserModel user);

    Optional<UserModel> retrieveById(Long id);

    ArrayList<UserModel> listByClientGroup(char clientGroup);

    ArrayList<UserModel> listByEmail(String email);

    boolean deleteUser(Long id);

}
