package com.example.restmysql.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RequestException extends RuntimeException {

    private int code;
    private HttpStatus status;
    private String error;

    public RequestException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.code = status.value();
        this.error = status.getReasonPhrase();
    }
}
