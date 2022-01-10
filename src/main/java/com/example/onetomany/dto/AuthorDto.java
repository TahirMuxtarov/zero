package com.example.onetomany.dto;

import com.example.onetomany.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class AuthorDto {

    private Long id;

    private Integer age;

    private String name;

    private String genre;

    private List<Movie> books;//=new ArrayList<>();


}
