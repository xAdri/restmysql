package com.example.restmysql.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(long id) {
        super("User not found: " + id);
    }

}
