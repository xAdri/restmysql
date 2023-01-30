package com.example.restmysql.mappers;

import com.example.restmysql.dto.PlaylistDTO;
import com.example.restmysql.dto.PlaylistMinimalDTO;
import com.example.restmysql.models.PlaylistModel;

import java.util.ArrayList;

public class PlaylistMapper {

    public static PlaylistDTO toDto(PlaylistModel playlist) {
        PlaylistDTO playlistDTO = new PlaylistDTO();

        playlistDTO.setName(playlist.getName());
        playlistDTO.setDuration(playlist.getDuration());

        return playlistDTO;
    }

    public static ArrayList<PlaylistMinimalDTO> toDtoArrayList(ArrayList<PlaylistModel> playlists) {
        ArrayList<PlaylistMinimalDTO> playlistMinimalDTOs = new ArrayList<>();

        for (PlaylistModel playlist : playlists) {
            PlaylistMinimalDTO playlistMinimalDTO = new PlaylistMinimalDTO();

            playlistMinimalDTO.setId(playlist.getId());
            playlistMinimalDTO.setName(playlist.getName());
            playlistMinimalDTO.setDuration(playlist.getDuration());
            playlistMinimalDTO.setUser(UserMapper.toMinimalDto(playlist.getUser()));

            playlistMinimalDTOs.add(playlistMinimalDTO);
        }

        return playlistMinimalDTOs;
    }

}
