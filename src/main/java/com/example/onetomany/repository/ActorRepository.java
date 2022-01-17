package com.example.onetomany.repository;

import com.example.onetomany.entity.Actor;
//import com.example.onetomany.entity.Actor_;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> , JpaSpecificationExecutor<Actor> ,PagingAndSortingRepository<Actor,Long>{

    List<Actor> findAllByNameLike(String name);

    List<Actor> findByAgeLessThan(

            Integer age
    );

    @Override
    default Page<Actor> findAll(Pageable pageable) {
    return null;
    }

    @Query("select a from Actor a where a.age >50")
    List<Actor>olderThan50();

    @Query("select a from Actor a where a.id=?1")
    Actor getByActorId(Long id);
    //Actor selectExistByAge(Integer age);
}
