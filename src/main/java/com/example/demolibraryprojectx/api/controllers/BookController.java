package com.example.demolibraryprojectx.api.controllers;

import com.example.demolibraryprojectx.business.abstracts.BookService;
import com.example.demolibraryprojectx.core.utilities.results.DataResult;
import com.example.demolibraryprojectx.core.utilities.results.Result;
import com.example.demolibraryprojectx.entity.concretes.Author;
import com.example.demolibraryprojectx.entity.concretes.Book;
import com.example.demolibraryprojectx.entity.concretes.Genre;
import com.example.demolibraryprojectx.entity.dtos.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/Book")
@SessionAttributes({"Kitap"})
public class BookController {
    private BookService bookService;

    private HttpSession httpSession;

    @Autowired
    public BookController(BookService bookService,HttpSession httpSession) {
        super();
        this.bookService = bookService;
        this.httpSession = httpSession;
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<Book>>>  getAll(){

        var result = this.bookService.getAll();

        return ResponseEntity.ok(result);

    }

    @GetMapping("/getAllbyDto")
    public ResponseEntity<DataResult<List<BookDto>>>  getAllbyDto(){

        var result = this.bookService.getAlltoDto();

        return ResponseEntity.ok(result);

    }

    @PostMapping("/getById")
    public ResponseEntity<DataResult<Book>>  getById(String id){

        var result = this.bookService.getById(id);
        if(result.isSuccess()) {
            return ResponseEntity.ok(result);}



            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);


    }

    @PostMapping("/getByName")
    public ResponseEntity<DataResult<List<Book>>> getByName(String bookName){

        var result = this.bookService.getByName(bookName);
        if(result.getData().size() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);}



            return ResponseEntity.ok(result) ;


    }

    @PostMapping("/getByAuthor")
    public ResponseEntity<DataResult<List<Book>>> getByAuthor(String author){

        var result = this.bookService.getByAuthor(author);
        if(result.getData().size() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);}



            return ResponseEntity.ok(result) ;


    }

    @PostMapping("/getByGenre")
    public ResponseEntity<DataResult<List<Book>>> getByGenre(String genre){

        var result = this.bookService.getByGenre(genre);
        if(result.getData().size() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);}



            return ResponseEntity.ok(result) ;


    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(Book book) {

        var result = this.bookService.add(book);
        if(result.isSuccess()) {
            return ResponseEntity.ok(result);}

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);

    }

    @PostMapping("/delete")
    public ResponseEntity<Result> delete(Book book) {

        var result = this.bookService.delete(book);
        if(result.isSuccess()) {
            return ResponseEntity.ok(result);}

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);

    }

    @PostMapping("/receivebookname")
    public ResponseEntity<String> receiveBookName(String bookName, HttpServletRequest httpServletRequest){
        httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("name", bookName);
        return ResponseEntity.ok("Kitap önbelleğe alındı.");
    }

    @PostMapping("/receiveauthor")
    public ResponseEntity<String> receiveAuthor(Author author, HttpServletRequest httpServletRequest){
        httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("authorInfo", author);
        return ResponseEntity.ok("Yazar önbelleğe alındı.");
    }

    @PostMapping("/receivegenre")
    public ResponseEntity<String> receiveGenre(Genre genre, HttpServletRequest httpServletRequest){
        httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("genreInfo", genre);
        return ResponseEntity.ok("Tür önbelleğe alındı.");
    }

    @PostMapping("/search")
    public ResponseEntity<DataResult<List<Book>>> search(String search){
        var result = this.bookService.search(search);
        if(result.getData().size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);}


            return ResponseEntity.ok(result) ;


    }
    }


