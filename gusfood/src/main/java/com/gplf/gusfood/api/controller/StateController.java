package com.gplf.gusfood.api.controller;

import com.gplf.gusfood.domain.model.State;
import com.gplf.gusfood.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateRepository repository;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<State> list() {
        return repository.findAll();
    }
}
