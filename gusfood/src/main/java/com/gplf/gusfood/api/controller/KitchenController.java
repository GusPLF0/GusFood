package com.gplf.gusfood.api.controller;

import com.gplf.gusfood.domain.exception.EntityInUseException;
import com.gplf.gusfood.domain.exception.EntityNotFoundException;
import com.gplf.gusfood.domain.model.Kitchen;
import com.gplf.gusfood.api.model.KitchensXmlWrapper;
import com.gplf.gusfood.domain.repository.KitchenRepository;
import com.gplf.gusfood.domain.service.KitchenService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kitchens")
public class KitchenController {

    @Autowired
    private KitchenService kitchenService;

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public KitchensXmlWrapper listXml() {
        return new KitchensXmlWrapper(kitchenService.findAll());
    }

    @GetMapping
    public List<Kitchen> list() {
        return kitchenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kitchen> find(@PathVariable Long id) {
        try {
            Kitchen kitchen = kitchenService.find(id);
            return ResponseEntity.ok(kitchen);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Kitchen add(@RequestBody Kitchen kitchen) {
        return kitchenService.save(kitchen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kitchen> edit(@PathVariable Long id, @RequestBody Kitchen kitchen) {
        try {
            Kitchen kitchenFounded = kitchenService.find(id);
            kitchenFounded.setName(kitchen.getName());
            kitchenService.save(kitchenFounded);
            return ResponseEntity.ok(kitchenFounded);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Kitchen> delete(@PathVariable Long id) {
        try {
            kitchenService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (EntityInUseException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }

}
