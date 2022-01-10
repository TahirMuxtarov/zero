package com.example.onetomany.dto;

import com.example.onetomany.entity.Author;
import com.example.onetomany.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class MovieDto {

    @Autowired
    private EntityManager entityManager;




    private Long id;

    private String title;

    private String isbn;


    private Author author;
}
