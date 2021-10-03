package com.example.demolibraryprojectx.business.concretes;

import com.example.demolibraryprojectx.business.abstracts.AuthorService;
import com.example.demolibraryprojectx.core.utilities.results.DataResult;
import com.example.demolibraryprojectx.core.utilities.results.Result;
import com.example.demolibraryprojectx.core.utilities.results.SuccessDataResult;
import com.example.demolibraryprojectx.core.utilities.results.SuccessResult;
import com.example.demolibraryprojectx.dataAcces.abstracts.AuthorDao;
import com.example.demolibraryprojectx.entity.concretes.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorManager implements AuthorService {
    private AuthorDao authorDao;

    @Autowired
    public AuthorManager(AuthorDao authorDao) {
        super();
        this.authorDao = authorDao;
    }

    @Override
    public DataResult<List<Author>> getAll() {

        return new SuccessDataResult<>(this.authorDao.findAll(), "Yazarlar listelendi");
    }

    @Override
    public Result add(Author author) {
        this.authorDao.save(author);
        return new SuccessResult("Yazar Eklendi.");
    }

    @Override
    public Result delete(Author author) {
        this.authorDao.delete(author);
        return new SuccessResult("Yazar Silindi.");
    }

}
