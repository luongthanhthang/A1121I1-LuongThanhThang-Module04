package com.codegym.repository;


import com.codegym.entity.Product;

import java.util.List;

public interface IProductRepository {
    void create(Product product);

    void update(Product product);

    void delete(String id);

    List<Product> findAll();

    Product findById(String id);

    List<Product> findByName(String name);
}
