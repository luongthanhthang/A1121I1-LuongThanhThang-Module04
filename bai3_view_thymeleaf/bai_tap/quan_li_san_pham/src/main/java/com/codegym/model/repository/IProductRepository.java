package com.codegym.model.repository;


import com.codegym.model.entity.Product;

import java.util.List;

public interface IProductRepository {
    void create(Product product);

    void update(Product product);

    void delete(String id);

    List<Product> findAll();

    Product findById(String id);

    List<Product> findByName(String name);
}
