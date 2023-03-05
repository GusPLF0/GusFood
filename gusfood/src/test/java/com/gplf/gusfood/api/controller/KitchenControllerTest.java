package com.gplf.gusfood.api.controller;

import com.gplf.gusfood.domain.model.Kitchen;
import com.gplf.gusfood.domain.repository.KitchenRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
class KitchenControllerTest {

    @Mock
    private KitchenRepository kitchenRepositoryMock;

    @InjectMocks
    private KitchenController kitchenController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldListAllWhenCalled() throws Exception {

    }

    @Test
    void find() {
    }

    @Test
    void add() {
    }

    @Test
    void edit() {
    }

    @Test
    void delete() {
    }
}