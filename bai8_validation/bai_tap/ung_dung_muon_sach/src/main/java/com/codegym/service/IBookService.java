package com.codegym.service;

import com.codegym.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    void create(Book book);
    void update(Book book);
    void delete(Integer id);
    Book findById(Integer id);
}
