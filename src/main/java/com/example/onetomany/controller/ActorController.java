package com.example.onetomany.controller;

import com.example.onetomany.entity.Actor;
//import com.example.onetomany.entity.Actor_;
import com.example.onetomany.repository.ActorRepository;
import com.example.onetomany.repositoryImpl.ActorRepositoryCustomImpl;
import com.example.onetomany.search.ActorSpecification;
import com.example.onetomany.search.SearchCriteria;
import com.example.onetomany.search.SearchOperation;
import com.example.onetomany.service.ActorService;
import liquibase.pro.packaged.P;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/actor/")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ActorRepositoryCustomImpl actorRepositoryCustomImpl;

    @Autowired
    private ActorService actorService;

    /*@GetMapping
    public List<Actor> actors (@RequestBody Actor actor){
      return actorRepository.actors(actor);
    }*/

    @GetMapping("spec/{namelike}")
    public List<Actor> findNameLike(@PathVariable String namelike){
        return actorRepository.findAllByNameLike(namelike);
    }
/*    @GetMapping("specLike/{name}")
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
    }*/
    @GetMapping("ageLessThanSpecAdvanced/{name}")
    public List<Actor>ageLessThanSpecAdvanced(@PathVariable String name){
        SearchCriteria searchCriteria = new SearchCriteria(SearchOperation.ENDS_WITH,name);

        ActorSpecification actorSpecification = new ActorSpecification(searchCriteria);
        Specification<Actor> spec = Specification.where(actorSpecification);
        return actorRepository.findAll(spec);
    }
   /* @GetMapping("namelikeXX/{age}/{name}")
    public List<Actor>ageLessThanAndNameLikeSpec2(@PathVariable Integer age, @PathVariable String name){

        return actorRepository.findAll((root, query, criteriaBuilder) ->
                criteriaBuilder.or(criteriaBuilder.equal(root.get(Actor_.NAME),name)
                        ,criteriaBuilder.lessThan(root.get(Actor_.AGE),age)));
                //.lessThan(root.get(Actor_.age),age));
    }*/
    @GetMapping("queryMethod/{age}")
    public List<Actor>actorList(@PathVariable Integer age){
        log.info("actorList");
        return actorRepository.findByAgeLessThan(age);
    }

   /* @GetMapping("namelikeXXX/{age}/{name}")
    public List<Actor>ageLessThanAndNameLikeSpec3(@PathVariable Integer age, @PathVariable String name){

        return actorRepository.findAll((root, query, criteriaBuilder) ->
                criteriaBuilder.or(criteriaBuilder.equal(root.get(Actor_.NAME),name)
                        ,criteriaBuilder.lessThan(root.get(Actor_.AGE),age)));
        //.lessThan(root.get(Actor_.age),age));
    }*/



        @GetMapping("olderThan50")
        public List<Actor>olderThan50(){
          return  actorService.getOlderThan50();
        }


        @PostMapping("/newActor")
        public Actor addNewActor(@RequestBody Actor actor){
            log.info("creating new Actor");
            return actorService.addNewActor(actor);
        }

}
