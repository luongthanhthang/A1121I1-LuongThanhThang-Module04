package com.codegym.service;


import com.codegym.entity.Borrow;

import java.util.List;

public interface IBorrowService {
    List<Borrow> findAll();
    void create(Borrow borrow);
    void update(Borrow borrow);
    void delete(Integer id);
    Borrow findById(Integer id);
}
