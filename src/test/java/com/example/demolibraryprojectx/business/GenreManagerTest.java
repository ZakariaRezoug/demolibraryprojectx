package com.example.demolibraryprojectx.business;

import com.example.demolibraryprojectx.business.abstracts.GenreService;
import com.example.demolibraryprojectx.business.concretes.GenreManager;
import com.example.demolibraryprojectx.core.utilities.results.Result;
import com.example.demolibraryprojectx.core.utilities.results.SuccessDataResult;
import com.example.demolibraryprojectx.core.utilities.results.SuccessResult;
import com.example.demolibraryprojectx.dataAcces.abstracts.GenreDao;
import com.example.demolibraryprojectx.entity.concretes.Genre;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class GenreManagerTest {

    private GenreService genreService;

    private GenreDao genreDao;

    Genre testGenre = new Genre();

    @Before
    public void setUp() throws Exception{
        genreDao = Mockito.mock(GenreDao.class);

        genreService = new GenreManager(genreDao);

        testGenre.setGenreName("Test-Tür adı");
    }

    @Test
    public void whenAddCalledWithGenre_itShouldReturnSuccessResult(){

        Mockito.when(genreDao.save(testGenre)).thenReturn(testGenre);

        Result testResult =genreService.add(testGenre);

        Result expected = new SuccessResult("Tür eklendi.");

        Assert.assertEquals(expected.getMessage(),testResult.getMessage());

        Mockito.verify(genreDao).save(testGenre);

    }

    @Test
    public void whenGetAll_itShouldReturnSuccessDataResult(){

        var result = genreService.getAll();

        var expected = new SuccessDataResult<List<Genre>>("Türler listelendi.");

        Assert.assertEquals(expected.getMessage(),result.getMessage());
    }
}
