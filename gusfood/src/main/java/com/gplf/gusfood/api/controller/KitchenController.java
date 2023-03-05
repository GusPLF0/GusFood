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
    private KitchenRepository repository;

    @Autowired
    private KitchenService kitchenService;

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public KitchensXmlWrapper listXml() {
        return new KitchensXmlWrapper(repository.findAll());
    }

    @GetMapping
    public List<Kitchen> list() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kitchen> find(@PathVariable Long id) {
        Optional<Kitchen> kitchenFounded = repository.findById(id);

        if (kitchenFounded.isPresent()) {
            return ResponseEntity.ok(kitchenFounded.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Kitchen add(@RequestBody Kitchen kitchen) {
        return kitchenService.save(kitchen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kitchen> edit(@PathVariable Long id, @RequestBody Kitchen kitchen) {

        Optional<Kitchen> optionalOfKitchenFounded = repository.findById(id);

        if (optionalOfKitchenFounded.isPresent()) {
            Kitchen kitchenFounded = optionalOfKitchenFounded.get();

            kitchenFounded.setName(kitchen.getName());

            kitchenFounded = this.add(kitchenFounded);

            return ResponseEntity.ok(kitchenFounded);
        }

        return ResponseEntity.notFound().build();

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
