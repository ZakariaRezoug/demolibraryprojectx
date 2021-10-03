package com.example.demolibraryprojectx.business.concretes;

import com.example.demolibraryprojectx.business.abstracts.GenreService;
import com.example.demolibraryprojectx.core.utilities.results.DataResult;
import com.example.demolibraryprojectx.core.utilities.results.Result;
import com.example.demolibraryprojectx.core.utilities.results.SuccessDataResult;
import com.example.demolibraryprojectx.core.utilities.results.SuccessResult;
import com.example.demolibraryprojectx.dataAcces.abstracts.GenreDao;
import com.example.demolibraryprojectx.entity.concretes.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenreManager implements GenreService {

    private GenreDao genreDao;

    @Autowired
    public GenreManager(GenreDao genreDao) {
        super();
        this.genreDao = genreDao;
    }

    @Override
    public DataResult<List<Genre>> getAll() {

        return new SuccessDataResult<List<Genre>>(this.genreDao.findAll(), "Kitaplar listelendi.");
    }

    @Override
    public Result add(Genre genre) {
        this.genreDao.save(genre);
        return new SuccessResult("Tür eklendi.");
    }
}
