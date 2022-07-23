package com.codegym.service;


import com.codegym.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IProductService {
    void create(Product product);
    void update(Product product);
    void delete(String id);
    Page<Product> findAll(Pageable pageable);
    Product findById(String id);
    Page<Product> findByName(String name, Pageable pageable);

}
