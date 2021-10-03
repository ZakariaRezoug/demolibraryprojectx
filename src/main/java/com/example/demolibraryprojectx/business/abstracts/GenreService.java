package com.example.demolibraryprojectx.business.abstracts;

import com.example.demolibraryprojectx.core.utilities.results.DataResult;
import com.example.demolibraryprojectx.core.utilities.results.Result;
import com.example.demolibraryprojectx.entity.concretes.Genre;

import java.util.List;

public interface GenreService {

    DataResult<List<Genre>> getAll();

    Result add(Genre genre);

}
