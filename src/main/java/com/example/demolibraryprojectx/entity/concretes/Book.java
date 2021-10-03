package com.example.demolibraryprojectx.entity.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("book")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @Field(name = "name")
    private String name;

    private Author author;

    private Genre genre;

    public Book(String name, Author author, Genre genre) {
        super();
        this.name = name;
        this.author = author;
        this.genre = genre;
    }
}
