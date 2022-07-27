package com.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codegym.entity.Product;
import com.codegym.repository.IProductRepository;

import java.util.List;


@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);

    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        return productRepository.search("%"+name+"%");
    }
}
