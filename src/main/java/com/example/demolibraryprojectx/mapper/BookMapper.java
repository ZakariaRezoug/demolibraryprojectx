package com.example.demolibraryprojectx.mapper;

import com.example.demolibraryprojectx.entity.concretes.Book;
import com.example.demolibraryprojectx.entity.dtos.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "book.genre.genreName", target = "genreName")
    @Mapping(source = "book.author.authorName", target = "authorName")
    BookDto entityToDto(Book book);

    @Mapping(source = "book.genre.genreName", target = "genreName")
    @Mapping(source = "book.author.authorName", target = "authorName")
    List<BookDto> entitiesToDto(List<Book> books);
}
