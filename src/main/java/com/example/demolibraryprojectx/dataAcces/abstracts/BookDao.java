package com.example.demolibraryprojectx.dataAcces.abstracts;

import com.example.demolibraryprojectx.entity.concretes.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends MongoRepository<Book, String> {

}
