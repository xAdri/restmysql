package com.example.restmysql.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PlaylistDTO {
    // Cambiar el nombre a PlaylistCreateDTO?
    private String name;
    private Double duration;
}
