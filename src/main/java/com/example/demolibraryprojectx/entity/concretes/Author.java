package com.example.demolibraryprojectx.entity.concretes;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("author")
public class Author {
    @Id
    private String id;

    @Field(name = "name")
    private String authorName;
}
