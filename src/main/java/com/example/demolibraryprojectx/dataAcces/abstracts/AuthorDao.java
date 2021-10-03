package com.example.demolibraryprojectx.dataAcces.abstracts;

import com.example.demolibraryprojectx.entity.concretes.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends MongoRepository<Author, String> {
}
