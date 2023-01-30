package com.example.restmysql.mappers;

import com.example.restmysql.dto.UserDTO;
import com.example.restmysql.dto.UserMinimalDTO;
import com.example.restmysql.models.UserModel;

import java.util.ArrayList;

public class UserMapper {

    public static UserDTO toDto(UserModel user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setBirthdate(user.getBirthdate());
        userDTO.setCity(user.getCity());
        userDTO.setAddress(user.getAddress());
        userDTO.setClientGroup(user.getClientGroup());

        return userDTO;
    }

    public static ArrayList<UserDTO> toDtoArrayList(ArrayList<UserModel> users) {
        ArrayList<UserDTO> userDTOs = new ArrayList<>();

        for (UserModel user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());
            userDTO.setBirthdate(user.getBirthdate());
            userDTO.setCity(user.getCity());
            userDTO.setAddress(user.getAddress());
            userDTO.setClientGroup(user.getClientGroup());
            userDTOs.add(userDTO);
        }

        return userDTOs;
    }

    public static UserMinimalDTO toMinimalDto(UserModel user) {
        UserMinimalDTO userMinimalDTO = new UserMinimalDTO();

        userMinimalDTO.setId(user.getId());
        userMinimalDTO.setEmail(user.getEmail());

        return userMinimalDTO;
    }
}
