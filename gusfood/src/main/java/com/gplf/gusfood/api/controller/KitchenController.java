package com.gplf.gusfood.api.controller;

import com.gplf.gusfood.domain.model.Kitchen;
import com.gplf.gusfood.domain.repository.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
