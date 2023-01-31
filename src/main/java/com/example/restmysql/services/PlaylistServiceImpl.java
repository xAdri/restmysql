package com.example.restmysql.services;

import com.example.restmysql.exceptions.UserNotFoundException;
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
        return playlistRepository.save(playlist);
    }

    @Override
    public ArrayList<PlaylistModel> retrieveByUserEmail(String email) {
        return playlistRepository.findByUserEmail(email);
    }

    @Override
    public ArrayList<PlaylistModel> retrieveByUserId(Long id) {
        return playlistRepository.findByUserId(id);
    }

    @Override
    public PlaylistModel retrieveById(Long id) {
        return playlistRepository.findOneById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public boolean deletePlaylist(Long id) {
        //Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            playlistRepository.deleteById(id);
        } catch (Exception err) {
            return false;
        }
        return true;
    }
}
