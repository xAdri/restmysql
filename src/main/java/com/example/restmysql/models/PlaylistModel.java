package com.example.restmysql.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "playlists")
@Getter
@Setter
@NoArgsConstructor
public class PlaylistModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String name;
    private Double duration;
    @ManyToOne // Muchas playlist para un solo usuario
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    public PlaylistModel(String name, Double duration) {
        this.name = name;
        this.duration = duration;
    }
}
