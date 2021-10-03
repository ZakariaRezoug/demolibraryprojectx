package com.example.demolibraryprojectx.api.controllers;

import com.example.demolibraryprojectx.business.abstracts.AuthorService;
import com.example.demolibraryprojectx.core.utilities.results.DataResult;
import com.example.demolibraryprojectx.core.utilities.results.Result;
import com.example.demolibraryprojectx.entity.concretes.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Author")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        super();
        this.authorService = authorService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<Author>>> getAll(){

        var result = this.authorService.getAll();

        return ResponseEntity.ok(result);

    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(Author author){
        var result = this.authorService.add(author);
        if(result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<Result> delete(Author author){
        var result = this.authorService.delete(author);
        if(result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }


}
