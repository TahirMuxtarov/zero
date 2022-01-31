package com.example.onetomany.service;

import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Movie;
import com.example.onetomany.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class EntityServices {

    private final AuthorRepository authorRepository;

    @Autowired
    private EntityManagerFactory factory;


    @Transactional(noRollbackFor  = Exception.class)
    public void testEntity() throws IOException{

        //EntityManager entityManager = factory.createEntityManager();

        Author author = new Author(55,"Tahir","horror");
        authorRepository.save(author);
        //authorRepository
        author.setName("cello");
        throw new RuntimeException();
    }


    //@Autowired
    //private final EntityManagerFactory entityManagerFactory;


  /*  @Transactional
    public void testEntity() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Author author = new Author(55,"Denis Vilenueve","scienct finction");
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(author);
        transaction.commit();
        System.out.println(2/0);
        entityManager.persist(author2);
        transaction.commit();
        //entityManager.flush();
        entityManager.close();

    }*/
}
