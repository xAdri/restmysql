package com.example.restmysql.services;

import com.example.restmysql.models.PlaylistModel;
import com.example.restmysql.repositories.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public ArrayList<PlaylistModel> listPlaylists() {
        return (ArrayList<PlaylistModel>) playlistRepository.findAll();
    }

    @Override
    public PlaylistModel postPlaylist(PlaylistModel playlist) {
        // TODO: Agregar automaticamente la id del usuario que hace la llamada
        return playlistRepository.save(playlist);
    }
}
