package com.gplf.gusfood.domain.service;

import com.gplf.gusfood.domain.exception.EntityInUseException;
import com.gplf.gusfood.domain.exception.EntityNotFoundException;
import com.gplf.gusfood.domain.model.Kitchen;
import com.gplf.gusfood.domain.repository.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KitchenService {

    @Autowired
    private KitchenRepository kitchenRepository;

    public Kitchen save(Kitchen kitchen) {
        return kitchenRepository.save(kitchen);
    }

    public void delete(Long id) {
        try {
            Kitchen kitchenFounded = kitchenRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Kitchen with code " + id + " doesn't exists"));

            kitchenRepository.delete(kitchenFounded);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException("Kitchen with code " + id + " can't be removed because it's in use!");
        }

    }
}
