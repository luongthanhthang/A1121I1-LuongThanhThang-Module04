package com.codegym.service.impl;

import com.codegym.entity.Borrow;
import com.codegym.repository.IBorrowRepository;
import com.codegym.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements IBorrowService {
    @Autowired
    IBorrowRepository borrowRepository;

    @Override
    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public void create(Borrow borrow) {
        
        borrowRepository.save(borrow);
    }

    @Override
    public void update(Borrow borrow) {
        borrowRepository.save(borrow);
    }

    @Override
    public void delete(Integer id) {
        borrowRepository.deleteById(id);
    }

    @Override
    public Borrow findById(Integer id) {
        return borrowRepository.findById(id).orElse(null);
    }
}
