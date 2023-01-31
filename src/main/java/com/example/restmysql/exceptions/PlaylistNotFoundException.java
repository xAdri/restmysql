package com.example.restmysql.exceptions;

public class PlaylistNotFoundException extends RuntimeException {

    public PlaylistNotFoundException() {
        super();
    }

    public PlaylistNotFoundException(String message) {
        super(message);
    }

    public PlaylistNotFoundException(long id) {
        super("Playlist not found: " + id);
    }
}
