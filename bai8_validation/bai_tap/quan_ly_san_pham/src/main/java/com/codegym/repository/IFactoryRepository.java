package com.codegym.repository;

import com.codegym.entity.Factory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFactoryRepository extends JpaRepository<Factory, Integer> {
}