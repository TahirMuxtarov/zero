package com.example.onetomany.service;

import com.example.onetomany.entity.Actor;
//import com.speedment.jpastreamer.application.JPAStreamer;
import com.example.onetomany.repository.ActorRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public List<Actor>getOlderThan50(){
        return actorRepository.olderThan50();
    }


    public Actor addNewActor(Actor actor) {
        return actorRepository.save(actor);
    }
}
