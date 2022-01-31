package com.example.onetomany.service;

import com.example.onetomany.entity.Actor;
import com.example.onetomany.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

@Service
@RequiredArgsConstructor
public class TestTransactions {

    @Autowired
    private ActorRepository actorRepository;

    //@Autowired
    private final EntityManagerFactory entityManagerFactory ;

    public void testingTransactions(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Actor actor = new Actor("Johnny Deep",58);
        entityManager.persist(actor);
        entityManager.flush();
       // entityManager.detach(actor);
        actor.setName("Salma Hayek");
       // entityManager.getTransaction().commit();
        actor.setName("Brendan Fraser");
        entityManager.close();


    }
}
