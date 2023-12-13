package com.workintech.zoo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ZooException extends RuntimeException{

    final private HttpStatus status;

    public ZooException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}