package com.example.demolibraryprojectx.business.concretes;

import com.example.demolibraryprojectx.business.abstracts.BookService;
import com.example.demolibraryprojectx.core.utilities.results.DataResult;
import com.example.demolibraryprojectx.core.utilities.results.Result;
import com.example.demolibraryprojectx.core.utilities.results.SuccessDataResult;
import com.example.demolibraryprojectx.core.utilities.results.SuccessResult;
import com.example.demolibraryprojectx.dataAcces.abstracts.BookDao;
import com.example.demolibraryprojectx.entity.concretes.Book;
import com.example.demolibraryprojectx.entity.dtos.BookDto;
import com.example.demolibraryprojectx.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookManager implements BookService {

    private BookDao bookDao;

    private BookMapper bookMapper;

    private MongoTemplate mongoTemplate;

    @Autowired
    public BookManager(BookDao bookDao,BookMapper bookMapper,MongoTemplate mongoTemplate) {

        this.bookDao = bookDao;

        this.bookMapper = bookMapper;

        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public DataResult<List<Book>> getAll() {
        return new SuccessDataResult<List<Book>>(this.bookDao.findAll(), "Kitaplar listelendi.");
    }

    @Override
    public DataResult<List<BookDto>> getAlltoDto() {
        var dto =bookMapper.entitiesToDto(bookDao.findAll());
        return new SuccessDataResult<List<BookDto>>(dto, "Kitaplar listelendi.");

    }

    @Override
    public DataResult<Book> getById(String id) {
        return new SuccessDataResult<Book>(this.bookDao.findById(id).get(),"Kitap listelendi.");
    }

    @Override
    public Result add(Book book) {
        this.bookDao.save(book);
        return new SuccessResult("Kitap eklendi");
    }

    @Override
    public Result delete(Book book) {
        this.bookDao.delete(book);
        return new SuccessResult("Kitap silindi");
    }

    @Override
    public DataResult<List<Book>> getByName(String bookName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(bookName));
        return new SuccessDataResult<>(mongoTemplate.find(query,Book.class));
    }

    @Override
    public DataResult<List<Book>> getByAuthor(String author) {
        Query query =new Query();
        query.addCriteria(Criteria.where("author.authorName").is(author));
        return new SuccessDataResult<>(mongoTemplate.find(query,Book.class));
    }

    @Override
    public DataResult<List<Book>> getByGenre(String genre) {
        Query query = new Query();
        query.addCriteria(Criteria.where("genre.genreName").is(genre));
        return new SuccessDataResult<>(mongoTemplate.find(query,Book.class));
    }

    @Override
    public DataResult<List<Book>> search(String search) {
        Query query = new Query();
        Criteria criteria = new Criteria().orOperator(
                Criteria.where("name").regex(search),
                Criteria.where("author.authorName").regex(search),
                Criteria.where("genre.genreName").regex(search)
        );
        query.addCriteria(criteria);
        return new SuccessDataResult<>(mongoTemplate.find(query,Book.class));
    }
}
