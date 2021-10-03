package com.example.demolibraryprojectx.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.TextScore;

@Data
@Document("book")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @Field(name = "name")
    @TextIndexed(weight = 4)
    private String name;

    @TextIndexed(weight = 3)
    private Author author;

    @TextIndexed(weight = 2)
    private Genre genre;


    @JsonIgnore
    @TextScore
    private Float score;

    public Book(String name, Author author, Genre genre) {
        super();
        this.name = name;
        this.author = author;
        this.genre = genre;
    }
}
