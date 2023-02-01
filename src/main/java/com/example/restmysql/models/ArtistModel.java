package com.example.restmysql.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "artists")
@Getter
@Setter
public class ArtistModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(name = "stage_name", unique = true, nullable = false)
    private String stageName;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;
}