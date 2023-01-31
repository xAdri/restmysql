package com.example.restmysql.services;

import com.example.restmysql.models.PlaylistModel;

import java.util.ArrayList;

public interface PlaylistService {

    ArrayList<PlaylistModel> listPlaylists();

    PlaylistModel postPlaylist(PlaylistModel playlist);

    ArrayList<PlaylistModel> retrieveByUserEmail(String email);

    ArrayList<PlaylistModel> retrieveByUserId(Long id);
}
