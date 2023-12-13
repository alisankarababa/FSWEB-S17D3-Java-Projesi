package com.workintech.zoo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Kangaroo {

    private long id;
    private String name;
    private int height;
    private int weight;
    private String gender;
    private boolean isAggressive;


}
