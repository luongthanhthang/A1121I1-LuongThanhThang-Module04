package com.codegym.service;

import com.codegym.entity.Factory;

import java.util.List;

public interface IFactoryService {
    void create(Factory factory);
    void update(Factory factory);
    void delete(int id);
    List<Factory> findAll();
    Factory findById(int id);
}
