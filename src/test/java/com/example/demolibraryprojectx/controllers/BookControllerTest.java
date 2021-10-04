package com.example.demolibraryprojectx.controllers;

import com.example.demolibraryprojectx.api.controllers.BookController;
import com.example.demolibraryprojectx.business.abstracts.BookService;
import com.example.demolibraryprojectx.core.utilities.results.Result;
import com.example.demolibraryprojectx.entity.concretes.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpSession;

public class BookControllerTest {

    private BookController bookController;

    private BookService bookService;

    private HttpSession httpSession;

    Book testBook = new Book();

    @Before
    public void setUp() throws Exception{
        bookService = Mockito.mock(BookService.class);
        httpSession =Mockito.mock(HttpSession.class);

        bookController = new BookController(bookService,httpSession);
        testBook.setName("Test-Kitap adı");
    }

    @Test
    public void whenAddCalledWithBook_itShouldReturnResponseEntity(){
        Result resultForService = new Result(true);

        Mockito.when(bookService.add(testBook)).thenReturn(resultForService);

        var testResult = bookController.add(testBook);

        ResponseEntity<Result> expected = ResponseEntity.ok(resultForService);

        Assert.assertEquals(expected,testResult);
    }

}
