package com.workintech.zoo.controller;


import com.workintech.zoo.entity.Kangaroo;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {

    private Map<Long, Kangaroo> kangarooMap;

    @PostConstruct
    private void init() {
        kangarooMap = new HashMap<>();
        kangarooMap.put(1L, new Kangaroo(1L, "kangaroo1", 180, 150, "male", true));
        kangarooMap.put(2L, new Kangaroo(2L, "kangaroo2", 185, 130, "female", false));
        kangarooMap.put(3L, new Kangaroo(3L, "kangaroo3", 150, 80, "female", false));
    }

    @GetMapping
    public List<Kangaroo> get() {
        return kangarooMap.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangaroo get(@PathVariable long id) {

        //TODO add id validation
        //TODO add kangaroo existence check

        return kangarooMap.get(id);
    }


    @PostMapping
    public Kangaroo post(@RequestBody Kangaroo kangaroo) {

        //TODO validate id
        //TODO validate if same id is free in kangarooMap
        //TODO check kangaroo fields

        kangarooMap.put(kangaroo.getId(), kangaroo);
        return kangaroo;
    }

    @PutMapping("/{id}")
    public Kangaroo put(@PathVariable long id, @RequestBody Kangaroo kangaroo) {

        //TODO check id existence
        //TODO check kangaroo fields


        kangaroo.setId(id);
        kangarooMap.put(id, kangaroo);
        return kangarooMap.get(id);
    }

    @DeleteMapping("/{id}")
    public Kangaroo delete(@PathVariable long id) {

        //TODO validate id
        //TODO check id existence

        return kangarooMap.remove(id);
    }
}
