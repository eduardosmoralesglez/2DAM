package com.docencia.aed.service;

import java.util.List;

import com.docencia.aed.entity.Author;
import com.docencia.aed.entity.Book;

public interface IAuthorService {
    List<Author> findAll();

    Author findById(long id);

    Author create(Author author);

    List<Book> findBooksByAuthor(long authorId);
}
