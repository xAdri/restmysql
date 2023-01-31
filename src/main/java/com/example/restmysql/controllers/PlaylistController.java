package com.example.restmysql.controllers;

import com.example.restmysql.dto.PlaylistDTO;
import com.example.restmysql.dto.PlaylistDetailDTO;
import com.example.restmysql.dto.PlaylistMinimalDTO;
import com.example.restmysql.exceptions.PlaylistNotFoundException;
import com.example.restmysql.exceptions.UnauthorizedDeleteException;
import com.example.restmysql.mappers.PlaylistMapper;
import com.example.restmysql.models.PlaylistModel;
import com.example.restmysql.models.UserModel;
import com.example.restmysql.services.PlaylistService;
import com.example.restmysql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        return new ResponseEntity<>(PlaylistMapper.toDtoUserArrayList(playlists), HttpStatus.OK);
    }

    @PostMapping(path = "/create", consumes = {"application/json"})
    public ResponseEntity<PlaylistDetailDTO> postUser(@RequestBody PlaylistModel playlist, Authentication auth) {

        PlaylistModel new_playlist = new PlaylistModel(playlist.getName(), playlist.getDuration());
        String email = auth.getPrincipal().toString();

        Optional<UserModel> user = userService.retrieveByEmail(email);
        new_playlist.setUser(user.orElse(new UserModel()));
        playlistService.postPlaylist(new_playlist);
        return new ResponseEntity<>(PlaylistMapper.toDtoDetail(new_playlist), HttpStatus.CREATED);
    }

    @GetMapping(path = "/me")
    public ResponseEntity<ArrayList<PlaylistDTO>> retrieveUserLoggedPlaylists(Authentication auth) {
        String email = auth.getPrincipal().toString();
        ArrayList<PlaylistModel> playlists = playlistService.retrieveByUserEmail(email);
        return new ResponseEntity<>(PlaylistMapper.toDtoArrayList(playlists), HttpStatus.OK);
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<ArrayList<PlaylistDTO>> retrieveUserPlaylists(@PathVariable("id") Long id) {
        ArrayList<PlaylistModel> playlists = playlistService.retrieveByUserId(id);
        return new ResponseEntity<>(PlaylistMapper.toDtoArrayList(playlists), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PlaylistDetailDTO> retrievePlaylist(@PathVariable("id") Long id) {
        PlaylistModel playlist = playlistService.retrieveById(id);
        return new ResponseEntity<>(PlaylistMapper.toDtoDetail(playlist), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deletePlaylist(@PathVariable("id") Long id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        PlaylistModel playlist = playlistService.retrieveById(id);

        if (playlist == null) {
            throw new PlaylistNotFoundException(id);
        }

        if (!playlist.getUser().getEmail().equals(principal)) {
            throw new UnauthorizedDeleteException("You are not authorized to delete this playlist");
        }

        if (!this.playlistService.deletePlaylist(id)) {
            throw new PlaylistNotFoundException(id);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
