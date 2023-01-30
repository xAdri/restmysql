package com.example.restmysql.controllers;

import com.example.restmysql.dto.PlaylistDTO;
import com.example.restmysql.dto.PlaylistMinimalDTO;
import com.example.restmysql.mappers.PlaylistMapper;
import com.example.restmysql.models.PlaylistModel;
import com.example.restmysql.models.UserModel;
import com.example.restmysql.services.PlaylistService;
import com.example.restmysql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<ArrayList<PlaylistMinimalDTO>> listPlaylists() {
        ArrayList<PlaylistModel> playlists = playlistService.listPlaylists();
        return new ResponseEntity<>(PlaylistMapper.toDtoArrayList(playlists), HttpStatus.OK);
    }

    @PostMapping(path = "/create", consumes = {"application/json"})
    public ResponseEntity<PlaylistDTO> postUser(@RequestBody PlaylistModel playlist, Authentication auth) {

        PlaylistModel new_playlist = new PlaylistModel(playlist.getName(), playlist.getDuration());
        String email = auth.getPrincipal().toString();

        Optional<UserModel> user = userService.retrieveByEmail(email);
        new_playlist.setUser(user.orElse(new UserModel()));
        playlistService.postPlaylist(new_playlist);
        return new ResponseEntity<>(PlaylistMapper.toDto(new_playlist), HttpStatus.CREATED);
    }
}
