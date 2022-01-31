package com.example.onetomany.service;

import com.example.onetomany.entity.Actor;
import com.example.onetomany.repository.ActorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ActorServiceTest {

    @Autowired
    private ActorService actorService;

    @Autowired
    private ActorRepository actorRepository;


   /* @MockBean
    ActorRepository actorRepository;*/

    @Test
    void getOlderThan50() {

        //ActorRepository actorRepository = PowerMockite.mock()

    }

    @Test
    void testGetOlderThan50() {
        Actor given = new Actor("Woody Harrelson",61);
        Actor given2 = new Actor("Matthew McConaughey",53);
        Actor given3 = new Actor("Woody2 Harrelson2",58);
        System.out.println("test1");
        when(actorService.getOlderThan50()).thenReturn(Stream.of(given,given2,given3).collect(Collectors.toList()));
        System.out.println("test2");
        assertEquals(3,actorService.getOlderThan50().size());



    }
}