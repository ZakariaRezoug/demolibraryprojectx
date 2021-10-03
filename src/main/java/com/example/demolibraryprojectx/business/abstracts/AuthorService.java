package com.example.demolibraryprojectx.business.abstracts;

import com.example.demolibraryprojectx.core.utilities.results.DataResult;
import com.example.demolibraryprojectx.core.utilities.results.Result;
import com.example.demolibraryprojectx.entity.concretes.Author;

import java.util.List;

public interface AuthorService {

    DataResult<List<Author>> getAll();

    Result add(Author author);

    Result delete(Author author);
}
