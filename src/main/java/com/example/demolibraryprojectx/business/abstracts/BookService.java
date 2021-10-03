package com.example.demolibraryprojectx.business.abstracts;

import com.example.demolibraryprojectx.core.utilities.results.DataResult;
import com.example.demolibraryprojectx.core.utilities.results.Result;
import com.example.demolibraryprojectx.entity.concretes.Book;
import com.example.demolibraryprojectx.entity.dtos.BookDto;

import javax.xml.crypto.Data;
import java.util.List;

public interface BookService {

    DataResult<List<Book>> getAll();

    DataResult<List<BookDto>> getAlltoDto();

    DataResult<Book> getById(String id);

    Result add(Book book);

    Result delete(Book book);

    DataResult<List<Book>> getByName(String bookName);

    DataResult<List<Book>> getByAuthor(String author);

    DataResult<List<Book>> getByGenre(String genre);

    DataResult<List<Book>> search(String search);
}
