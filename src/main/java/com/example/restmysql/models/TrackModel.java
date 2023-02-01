/*
package com.example.restmysql.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Duration;

@Entity
@Table(name = "tracks")
@Getter
@Setter
public class TrackModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String name;
    private Duration duration;

    // Una cancion siempre tiene que ir en un album como minimo
}
 */