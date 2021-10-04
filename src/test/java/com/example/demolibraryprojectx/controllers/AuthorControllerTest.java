package com.example.demolibraryprojectx.controllers;

import com.example.demolibraryprojectx.api.controllers.AuthorController;
import com.example.demolibraryprojectx.business.abstracts.AuthorService;
import com.example.demolibraryprojectx.core.utilities.results.Result;
import com.example.demolibraryprojectx.entity.concretes.Author;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

public class AuthorControllerTest {
    private AuthorController authorController;

    private AuthorService authorService;

    Author testAuthor = new Author();

    @Before
    public void setUp() throws Exception{
        authorService = Mockito.mock(AuthorService.class);

        authorController = new AuthorController(authorService);

        testAuthor.setAuthorName("Test-Yazar adı");
    }

    @Test
    public void whenAddCalledWithAuthor_itShouldReturnResponseEntity(){
        Result resultForService = new Result(true);

        Mockito.when(authorService.add(testAuthor)).thenReturn(resultForService);

        var result = authorController.add(testAuthor);

        ResponseEntity<Result> expected = ResponseEntity.ok(resultForService);

        Assert.assertEquals(expected,result);


    }
}
