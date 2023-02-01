/*
package com.example.restmysql.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "events")
@Getter
@Setter
public class EventModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;

    // Cada evento tiene que estar asociado a una sala
    // Cada evento estará asociado a una ciudad
}


 */