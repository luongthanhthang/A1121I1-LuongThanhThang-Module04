package com.codegym.service;

import com.codegym.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product customer);

    void remove(int id);

    List<Product> search(String name);
}
