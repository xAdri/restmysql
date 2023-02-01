/*
package com.example.restmysql.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;

@Entity
@Table(name = "albums")
@Getter
@Setter
public class AlbumModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String name;
    private Duration duration; // suma de todas las canciones
    private LocalDate creationDate;

    // un album siempre tiene que ir asociado a 1 o muchos artistas

}


 */