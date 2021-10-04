package com.example.demolibraryprojectx.business;

import com.example.demolibraryprojectx.business.abstracts.AuthorService;
import com.example.demolibraryprojectx.business.concretes.AuthorManager;
import com.example.demolibraryprojectx.core.utilities.results.Result;
import com.example.demolibraryprojectx.core.utilities.results.SuccessDataResult;
import com.example.demolibraryprojectx.core.utilities.results.SuccessResult;
import com.example.demolibraryprojectx.dataAcces.abstracts.AuthorDao;
import com.example.demolibraryprojectx.entity.concretes.Author;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class AuthorManagerTest {

    private AuthorService authorService;

    private AuthorDao authorDao;

    Author testAuthor = new Author();

    @Before
    public void setUp() throws Exception{

        authorDao = Mockito.mock(AuthorDao.class);

        authorService = new AuthorManager(authorDao);

        testAuthor.setAuthorName("Test-Yazar Adı");
    }

    @Test
    public void whenAddCalledWithAuthor_itShouldReturnSuccessResult(){

        Mockito.when(authorDao.save(testAuthor)).thenReturn(testAuthor);

        Result testResult = authorService.add(testAuthor);

        Result expected = new SuccessResult("Yazar Eklendi.");

        Assert.assertEquals(expected.getMessage(),testResult.getMessage());

        Mockito.verify(authorDao).save(testAuthor);


    }

    @Test
    public void whenGetAll_itShouldReturnSuccessDataResult(){

        var result = authorService.getAll();

        var expected = new SuccessDataResult<List<Author>>("Yazarlar listelendi");

        Assert.assertEquals(expected.getMessage(),result.getMessage());
    }
}
