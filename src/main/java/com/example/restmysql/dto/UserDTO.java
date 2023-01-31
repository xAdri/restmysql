package com.example.restmysql.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthdate;
    private String city;
    private String address;
    private char clientGroup;
}
