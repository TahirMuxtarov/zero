package com.example.onetomany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "actors_movies",
    joinColumns = @JoinColumn(name="actor_id"),
    inverseJoinColumns =@JoinColumn(name= "movie_id"))
    private Set<Movie> movies = new HashSet<>();
}
