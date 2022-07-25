package com.codegym.service.impl;

import com.codegym.entity.Book;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        List<Book> bookList = bookRepository.findAll();
        for (Book book : bookList) {
            if (book.getQuantity() > 0) {
                book.setStatus(true);
            } else {
                book.setStatus(false);
            }
        }
        return bookList;
    }

    @Override
    public void create(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findById(Integer id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book.getQuantity() > 0) {
            book.setStatus(true);
        } else {
            book.setStatus(false);
        }
        return book;
    }
}
