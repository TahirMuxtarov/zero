package com.example.onetomany.entity;

import com.example.onetomany.listeners.ActorListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@EntityListeners(ActorListener.class)
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


    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "actors_movies",
            joinColumns = @JoinColumn(name="actor_id"),
            inverseJoinColumns =@JoinColumn(name= "movie_id"))
    private Set<Movie> movies = new HashSet<>();

    /*public Actor(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Actor(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }*/

    public Actor(String name, Integer age, Set<Movie> movies) {
        this.name = name;
        this.age = age;
        this.movies = movies;
    }

    public Actor(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

/*    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", movies=" + movies +
                '}';
    }*/

    public void addMovie(Movie movie) {
        this.movies.add(movie);
        movie.getActors().add(this);
    }
    public void removeMovie(Movie movie) {
        this.movies.remove(movie);
        movie.getActors().remove(this);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                //", movies=" + movies +
                '}';
    }
}
