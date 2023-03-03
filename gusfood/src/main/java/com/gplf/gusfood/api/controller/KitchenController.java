package com.gplf.gusfood.api.controller;

import com.gplf.gusfood.domain.model.Kitchen;
import com.gplf.gusfood.domain.repository.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kitchens")
public class KitchenController {

    @Autowired
    private KitchenRepository repository;

    @GetMapping
    public List<Kitchen> list() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Kitchen find(@PathVariable Long id) {
        return repository.findById(id).get();
    }
}
