package com.example.restmysql.mappers;

import com.example.restmysql.dto.PlaylistCreateDTO;
import com.example.restmysql.dto.PlaylistDTO;
import com.example.restmysql.dto.PlaylistDetailDTO;
import com.example.restmysql.dto.PlaylistMinimalDTO;
import com.example.restmysql.models.PlaylistModel;
import com.example.restmysql.utils.Utils;

import java.util.ArrayList;

public class PlaylistMapper {

    public static PlaylistCreateDTO toDtoCreate(PlaylistModel playlist) {
        PlaylistCreateDTO playlistCreateDTO = new PlaylistCreateDTO();

        playlistCreateDTO.setName(playlist.getName());
        playlistCreateDTO.setDuration(playlist.getDuration());

        return playlistCreateDTO;
    }

    public static PlaylistDTO toDto(PlaylistModel playlist) {
        PlaylistDTO playlistDTO = new PlaylistDTO();


        playlistDTO.setId(playlist.getId());
        playlistDTO.setName(playlist.getName());
        playlistDTO.setDuration(Utils.secondsToTimeFormat(playlist.getDuration()));

        return playlistDTO;
    }

    public static ArrayList<PlaylistMinimalDTO> toDtoUserArrayList(ArrayList<PlaylistModel> playlists) {
        ArrayList<PlaylistMinimalDTO> playlistMinimalDTOs = new ArrayList<>();

        for (PlaylistModel playlist : playlists) {
            PlaylistMinimalDTO playlistMinimalDTO = new PlaylistMinimalDTO();

            playlistMinimalDTO.setId(playlist.getId());
            playlistMinimalDTO.setName(playlist.getName());
            playlistMinimalDTO.setDuration(Utils.secondsToTimeFormat(playlist.getDuration()));
            playlistMinimalDTO.setUser(UserMapper.toMinimalDto(playlist.getUser()));

            playlistMinimalDTOs.add(playlistMinimalDTO);
        }

        return playlistMinimalDTOs;
    }

    public static ArrayList<PlaylistDTO> toDtoArrayList(ArrayList<PlaylistModel> playlists) {
        ArrayList<PlaylistDTO> playlistDTOs = new ArrayList<>();

        for (PlaylistModel playlist : playlists) {
            PlaylistDTO playlistDTO = new PlaylistDTO();

            playlistDTO.setId(playlist.getId());
            playlistDTO.setName(playlist.getName());
            playlistDTO.setDuration(Utils.secondsToTimeFormat(playlist.getDuration()));

            playlistDTOs.add(playlistDTO);
        }

        return playlistDTOs;
    }

    public static PlaylistDetailDTO toDtoDetail(PlaylistModel playlist) {
        PlaylistDetailDTO playlistDetailDTO = new PlaylistDetailDTO();

        playlistDetailDTO.setId(playlist.getId());
        playlistDetailDTO.setName(playlist.getName());
        playlistDetailDTO.setDuration(Utils.secondsToTimeFormat(playlist.getDuration()));
        playlistDetailDTO.setUser(UserMapper.toMinimalDto(playlist.getUser()));

        return playlistDetailDTO;
    }
}
