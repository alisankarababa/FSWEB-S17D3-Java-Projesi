package com.workintech.zoo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Koala {

    private long id;
    private String name;
    private int weight;
    private int sleepHour;
    private String gender;

}
