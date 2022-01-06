package com.example.onetomany.dto;

import com.example.onetomany.entity.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class AuthorDto {

   // private Long id;

    private Integer age;

    private String name;

    private String genre;

    private List<Book> books;//=new ArrayList<>();


}
