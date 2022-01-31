package com.example.onetomany.controller;

import com.example.onetomany.entity.Actor;
//import com.example.onetomany.entity.Actor_;
import com.example.onetomany.entity.Movie;
import com.example.onetomany.exceptions.InvalidRequestException;
import com.example.onetomany.repository.ActorRepository;
import com.example.onetomany.repositoryImpl.ActorRepositoryCustomImpl;
import com.example.onetomany.search.ActorSpecification;
import com.example.onetomany.search.SearchCriteria;
import com.example.onetomany.search.SearchOperation;
import com.example.onetomany.service.ActorService;
import com.example.onetomany.service.ManyToManyServiceTest;
import liquibase.pro.packaged.P;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/actor/")
public class ActorController {

    Logger logger = LoggerFactory.getLogger(ActorController.class);

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ActorRepositoryCustomImpl actorRepositoryCustomImpl;

    @Autowired
    private ManyToManyServiceTest manyToManyServiceTest;

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
        log.debug("actorList");
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


        @PostMapping("/newActorWithNewMovieAndAuthor")
        public Actor addNewActor(@RequestBody Actor actor){
            System.out.println(actor.getMovies());
            log.info("creating new Actor");
            return actorService.addNewActor(actor);
        }

        /// CRUD operations for testing


        @GetMapping("getAll")
        public List<Actor> getAllActors(){
            log.debug("getAllActors");
            return actorService.findAll();
        }
        @GetMapping("byId/{id}")
            public Actor getActorById (@PathVariable Long id){
                return actorRepository.findById(id).get();
            }

        @PostMapping("newActor")
        public Actor createNewActor(@RequestBody Actor actor){
            return actorRepository.save(actor);
        }

        @PutMapping
        public Actor updateActor(@RequestBody Actor actor)throws ChangeSetPersister.NotFoundException {
            if(actor == null||actor.getId()==null){
                throw new InvalidRequestException("Actor or ID must not be null!");
            }
            Optional<Actor> actorOptional = actorRepository.findById(actor.getId());
            if(actorOptional.isEmpty()){
                throw new ChangeSetPersister.NotFoundException();
            }
            Actor actor1 = actorOptional.get();
            actor1.setAge(actor.getAge());
            actor1.setName(actor.getName());
            return actorRepository.save(actor1);
        }
       /* @DeleteMapping("/{id}")
        public void deleteActorById(@PathVariable Long id)throws Exception{
            if(actorRepository.findById(id).isEmpty()){
                throw new RuntimeException("actor not found by id given");
            }
             actorRepository.deleteById(id);
        }*/
        @PostMapping("newMovieExistingActor/{id}")
        public void newMovieExistingAuthor(@PathVariable Long id,@RequestBody Movie movie) throws InterruptedException {
            log.info("newMovieExistingActorTest");
            System.out.println("xxxxxxxxxxxxx");
            Thread.sleep(100);
             actorService.newMovieExistingAuthor(id,movie);
        }

        /// Testing ManyToMany insert new actor with new movie from service when main side is actor
        @PostMapping("testingmanytomany")
        public void testing(){
            System.err.println("Point 111");
            manyToManyServiceTest.test();
        }

        @PostMapping("testingmanytomany/{id}")
        public void newMoviesExistingActor(@PathVariable Long id,@RequestBody Set<Movie> movies){
            actorService.saveNewMoviesExistingActor(id,movies);
        }


        @DeleteMapping("/{id}")
        public void deleteActorById(@PathVariable Long id){
            //manyToManyServiceTest.test2(id);
            actorRepository.deleteById(id);
        }


        @PostMapping("movies/{id}/{idx}")
        public void testx(@PathVariable Long id,@PathVariable Long idx){
            actorService.testx(id,idx);
        }

}
