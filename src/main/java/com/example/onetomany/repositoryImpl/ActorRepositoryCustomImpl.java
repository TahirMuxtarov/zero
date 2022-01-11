package com.example.onetomany.repositoryImpl;

import com.example.onetomany.entity.Actor;
import com.example.onetomany.entity.Actor_;
import com.example.onetomany.entity.Movie;
import com.example.onetomany.repository.ActorRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ActorRepositoryCustomImpl implements ActorRepositoryCustom {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Actor> actors(Actor actorx) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Actor> criteriaQuery = criteriaBuilder.createQuery(Actor.class);
        Root<Actor> actor = criteriaQuery.from(Actor.class);
        Predicate name3Predicate =null;
        if(actorx.getName()!=null || actorx.getAge()!=null){
            Predicate name1Predicate = criteriaBuilder.equal(actor.get(Actor_.NAME),actorx.getName());
            Predicate name2Predicate = criteriaBuilder.greaterThan(actor.get(Actor_.AGE),actorx.getAge());

            name3Predicate = criteriaBuilder.or(name1Predicate,name2Predicate);
        }


        //Predicate name3Predicate = criteriaBuilder.equal(movie.get("age"),name[1]);
        //criteriaQuery.where(criteriaBuilder.equal(actor.get(actor_.name),"leonardo"));
        //criteriaQuery.having()
        //criteriaQuery.select(actor).where(criteriaBuilder.equal(actor.get()));
        criteriaQuery.where(name3Predicate);
        TypedQuery<Actor> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }






    public static Specification<Actor> likeFirstName(String name){
        if(name==null){
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get(Actor_.NAME),"%"+name+"%");
        };
    }



    public Specification<Actor> nameLikeXXX(String name){
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(root.get(Actor_.NAME), "%"+name+"%");
    }

}
