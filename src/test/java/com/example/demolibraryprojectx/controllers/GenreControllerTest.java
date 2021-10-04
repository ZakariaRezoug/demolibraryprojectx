package com.example.demolibraryprojectx.controllers;

import com.example.demolibraryprojectx.api.controllers.GenreController;
import com.example.demolibraryprojectx.business.abstracts.GenreService;
import com.example.demolibraryprojectx.core.utilities.results.Result;
import com.example.demolibraryprojectx.entity.concretes.Genre;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

public class GenreControllerTest {

    private GenreController genreController;

    private GenreService genreService;

    Genre testGenre = new Genre();

    @Before
    public void setUp() throws Exception{
        genreService = Mockito.mock(GenreService.class);

        genreController = new GenreController(genreService);

        testGenre.setGenreName("Test-Tür Adı");
    }

    @Test
    public void whenAddCalledWithGenre_itShouldReturnResponseEntity(){
        Result resultForService = new Result(true);
        Mockito.when(genreService.add(testGenre)).thenReturn(resultForService);

        var testResult = genreController.add(testGenre);
        ResponseEntity<Result> expected = ResponseEntity.ok(resultForService);
        Assert.assertEquals(expected,testResult);
    }
}
