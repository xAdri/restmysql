package com.example.restmysql.exceptions;

public class UnauthorizedDeleteException extends RuntimeException {

    public UnauthorizedDeleteException() {
        super();
    }

    public UnauthorizedDeleteException(String message) {
        super(message);
    }

}
