package com.example.onetomany.controller;

import com.example.onetomany.entity.Actor;
import com.example.onetomany.repository.ActorRepository;
import io.restassured.mapper.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(ActorController.class)
@SpringBootTest
@AutoConfigureMockMvc
class ActorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ActorRepository actorRepository;

    Actor actor1 = new Actor("Javier Bardem",53);
    Actor actor2 = new Actor("Josh Brolin",54);
    Actor actor3 = new Actor("Timothee Chalamet",27);

    @Test
    void getAllActors_success() throws Exception{
        List<Actor> list = new ArrayList<>(Arrays.asList(actor1,actor2,actor3));
        Mockito.when(actorRepository.findAll()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/actor/getAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[2].name",is("Timothee Chalamet")));


    }

    @Test
    public void getActorById_success() throws Exception {
        Mockito.when(actorRepository.findById(actor1.getId())).thenReturn(java.util.Optional.of(actor1));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/actor/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Javier Bardem")));
    }
    @Test
    void createNewActor() {
    }

    @Test
    void updateActor() {
    }

    @Test
    void deleteActorById() {
    }
}