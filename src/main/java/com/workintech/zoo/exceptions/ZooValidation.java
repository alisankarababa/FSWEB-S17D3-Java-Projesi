package com.workintech.zoo.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class ZooValidation {

    public static void id(long id) {
        if(id < 0) {
            throw new ZooException(HttpStatus.BAD_REQUEST, "Id cannot be negative");
        }
    }

    public static <E> void keyDoesNotExist(long id, Map<Long, E> map) {
        if(!map.containsKey(id)) {
            throw new ZooException(HttpStatus.NOT_FOUND, "Could not find id: " + id);
        }
    }

    public static <E> void keyExists(long id, Map<Long, E> map) {
        if(map.containsKey(id)) {
            throw new ZooException(HttpStatus.BAD_REQUEST, String.format("Id %d already exists", id));
        }
    }
}