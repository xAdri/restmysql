package com.example.restmysql.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String name;
    private LocalDate birthdate;
    private String address;
    @Column(unique = true, nullable = false)
    private String email;
    private String phoneNumber;
    private LocalDate entryDate;
    private char clientGroup;
    private String city;
}
