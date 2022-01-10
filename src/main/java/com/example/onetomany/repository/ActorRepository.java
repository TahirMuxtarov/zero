package com.example.onetomany.repository;

import com.example.onetomany.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> ,ActorRepositoryCustom, JpaSpecificationExecutor<Actor> {

    List<Actor> findAllByNameLike(String name);

}
