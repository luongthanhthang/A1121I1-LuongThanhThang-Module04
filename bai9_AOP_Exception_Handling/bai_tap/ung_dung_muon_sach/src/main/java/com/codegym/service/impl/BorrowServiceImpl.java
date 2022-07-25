package com.codegym.service.impl;

import com.codegym.entity.Book;
import com.codegym.entity.Borrow;
import com.codegym.repository.IBookRepository;
import com.codegym.repository.IBorrowRepository;
import com.codegym.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BorrowServiceImpl implements IBorrowService {
    @Autowired
    IBorrowRepository borrowRepository;

    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public void create(Borrow borrow, Integer id) {
        // tạo phiếu mượn sách
        borrow.setBorrowId((new Random().nextInt(90000) + 10000) + "");
        Optional<Book> book = bookRepository.findById(id);
        book.get().setQuantity(book.get().getQuantity() - 1);
        borrow.setBook(book.get());

        borrowRepository.save(borrow);
    }

    @Override
    public void update(Borrow borrow) {
        borrowRepository.save(borrow);
    }

    @Override
    public void delete(String id) {
        //trả sách
        Borrow borrow = borrowRepository.findByBorrowId(id);
        Optional<Book> book = bookRepository.findById(borrow.getBook().getId());
        book.get().setQuantity(book.get().getQuantity() + 1);

        borrowRepository.deleteById(borrow.getId());
    }

    @Override
    public Borrow findByBorrowId(String id) {
        return borrowRepository.findByBorrowId(id);
    }
}
