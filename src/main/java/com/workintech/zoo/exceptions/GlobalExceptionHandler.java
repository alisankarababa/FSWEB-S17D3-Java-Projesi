package com.workintech.zoo.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler()
    public ResponseEntity<ZooExceptionResponse> hZooException(ZooException zooException) {

        ZooExceptionResponse resp = new ZooExceptionResponse(System.currentTimeMillis(), zooException.getMessage(), zooException.getStatus());
        return new ResponseEntity<>(resp, resp.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ZooExceptionResponse> hException(Exception exception) {
        ZooExceptionResponse resp = new ZooExceptionResponse(System.currentTimeMillis(), exception.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(resp, resp.getStatus());
    }

}