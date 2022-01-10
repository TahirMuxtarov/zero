package com.example.onetomany.controller;

import com.example.onetomany.entity.Actor;
import com.example.onetomany.repository.ActorRepository;
import com.example.onetomany.repositoryImpl.ActorRepositoryCustomImpl;
import com.example.onetomany.search.ActorSpecification;
import com.example.onetomany.search.SearchCriteria;
import com.example.onetomany.search.SearchOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor/")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ActorRepositoryCustomImpl actorRepositoryCustomImpl;

    @GetMapping
    public List<Actor> actors (@RequestBody Actor actor){
      return actorRepository.actors(actor);
    }

    @GetMapping("spec/{namelike}")
    public List<Actor> findNameLike(@PathVariable String namelike){
        return actorRepository.findAllByNameLike(namelike);
    }
    @GetMapping("specLike/{name}")
    public List<Actor>findLikefirstName(@PathVariable String name){
        Specification<Actor> spec = Specification.where(ActorSpecification.likeFirstName(name));
        return actorRepository.findAll(spec);
    }
    @GetMapping("ageLessThanSpec/{age}")
    public List<Actor>ageLessThanSpec(@PathVariable Integer age){
        Specification<Actor> spec = Specification.where(ActorSpecification.ageLessThan(age));
        return actorRepository.findAll(spec);
    }
    @GetMapping("ageLessThanAndNameLike/{age}/{name}")
    public List<Actor>ageLessThanAndNameLikeSpec(@PathVariable Integer age,@PathVariable String name){
        Specification<Actor> spec = Specification.where(ActorSpecification.ageLessThan(age).or(ActorSpecification.likeFirstName(name)));
        return actorRepository.findAll(spec);
    }
    @GetMapping("ageLessThanSpecAdvanced/{name}")
    public List<Actor>ageLessThanSpecAdvanced(@PathVariable String name){
        SearchCriteria searchCriteria = new SearchCriteria(SearchOperation.ENDS_WITH,name);

        ActorSpecification actorSpecification = new ActorSpecification(searchCriteria);
        Specification<Actor> spec = Specification.where(actorSpecification);
        return actorRepository.findAll(spec);
    }
    @GetMapping("namelikeXX/{name}")
    public List<Actor>ageLessThanAndNameLikeSpec(@PathVariable String name){
        Specification<Actor> spec = Specification.where(actorRepositoryCustomImpl.nameLikeXXX(name));

        return actorRepository.findAll(spec);
    }
}
