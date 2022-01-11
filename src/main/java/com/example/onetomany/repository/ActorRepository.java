package com.example.onetomany.repository;

import com.example.onetomany.entity.Actor;
import com.example.onetomany.entity.Actor_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> , JpaSpecificationExecutor<Actor> {

    List<Actor> findAllByNameLike(String name);

    List<Actor> findByAgeLessThan(

            Integer age
    );

}
