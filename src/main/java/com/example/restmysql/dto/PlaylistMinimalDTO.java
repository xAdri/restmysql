package com.example.restmysql.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PlaylistMinimalDTO {
    private Long id;
    private String name;
    private String duration;
    private UserMinimalDTO user;
}
