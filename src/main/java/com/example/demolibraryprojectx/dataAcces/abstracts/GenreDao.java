package com.example.demolibraryprojectx.dataAcces.abstracts;

import com.example.demolibraryprojectx.entity.concretes.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreDao extends MongoRepository<Genre,String> {
}
