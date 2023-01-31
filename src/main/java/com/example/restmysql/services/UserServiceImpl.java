package com.example.restmysql.services;

import com.example.restmysql.models.UserModel;
import com.example.restmysql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public ArrayList<UserModel> listUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel postUser(UserModel user) {
        // Asignarle la password y mandarla por mail

        // Password se pasa en la request y se encripta
        String encrypted_password = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encrypted_password);
        return userRepository.save(user);
    }

    public Optional<UserModel> retrieveById(Long id) {
        return userRepository.findById(id);
    }

    public ArrayList<UserModel> listByClientGroup(char clientGroup) {
        return userRepository.findByClientGroup(clientGroup);
    }

    public ArrayList<UserModel> listByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception err) {
            return false;
        }
        return true;
    }

    public Optional<UserModel> retrieveByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }
}
