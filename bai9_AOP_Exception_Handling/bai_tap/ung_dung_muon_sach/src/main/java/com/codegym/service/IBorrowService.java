package com.codegym.service;


import com.codegym.entity.Borrow;

import java.util.List;

public interface IBorrowService {
    List<Borrow> findAll();
    void create(Borrow borrow, Integer id);
    void update(Borrow borrow);
    void delete(String id);
    Borrow findByBorrowId(String id);
}
