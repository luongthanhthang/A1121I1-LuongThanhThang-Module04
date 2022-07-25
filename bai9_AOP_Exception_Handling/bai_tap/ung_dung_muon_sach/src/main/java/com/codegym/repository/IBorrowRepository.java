package com.codegym.repository;

import com.codegym.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowRepository extends JpaRepository<Borrow, Integer> {
    Borrow findByBorrowId(String borrowId);
}
