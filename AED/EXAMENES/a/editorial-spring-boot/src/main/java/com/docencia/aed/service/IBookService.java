package com.docencia.aed.service;

import java.util.List;

import com.docencia.aed.entity.Book;

public interface IBookService {
    List<Book> findAll();

    Book findById(long id);

    Book create(Book Book);

    
}
