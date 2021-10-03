package com.example.demolibraryprojectx.dataAcces.abstracts;

import com.example.demolibraryprojectx.entity.concretes.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User,String> {
}
