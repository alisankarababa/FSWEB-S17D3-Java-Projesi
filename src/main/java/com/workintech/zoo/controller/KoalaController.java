package com.workintech.zoo.controller;


import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.entity.Koala;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {

    private Map<Long, Koala> koalaMap;

    @PostConstruct
    private void init() {
        koalaMap = new HashMap<>();
        koalaMap.put(1L, new Koala(1L, "koala1", 180, 150, "male"));
        koalaMap.put(2L, new Koala(2L, "koala2", 185, 130, "female"));
        koalaMap.put(3L, new Koala(3L, "koala3", 150, 80, "female"));
    }

    @GetMapping
    public List<Koala> get() {
        return koalaMap.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Koala get(@PathVariable long id) {

        //TODO add id validation
        //TODO add koala existence check

        return koalaMap.get(id);
    }

    @PostMapping
    public Koala post(@RequestBody Koala koala) {

        //TODO validate id
        //TODO validate if same id is free in koalaMap
        //TODO check koala fields

        koalaMap.put(koala.getId(), koala);
        return koala;
    }

    @PutMapping("/{id}")
    public Koala put(@PathVariable long id, @RequestBody Koala koala) {

        //TODO check id existence
        //TODO check koala fields


        koala.setId(id);
        koalaMap.put(id, koala);
        return koalaMap.get(id);
    }

    @DeleteMapping("/{id}")
    public Koala delete(@PathVariable long id) {

        //TODO validate id
        //TODO check id existence

        return koalaMap.remove(id);
    }

}
