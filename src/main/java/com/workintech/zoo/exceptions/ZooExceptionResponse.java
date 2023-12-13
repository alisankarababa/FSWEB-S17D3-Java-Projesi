package com.workintech.zoo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ZooExceptionResponse {

    private long timestamp;
    private String message;
    private HttpStatus status;
}