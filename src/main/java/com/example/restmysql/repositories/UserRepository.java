package com.example.restmysql.repositories;

import com.example.restmysql.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    ArrayList<UserModel> findByClientGroup(char clientGroup);
    ArrayList<UserModel> findByEmail(String email);
}
