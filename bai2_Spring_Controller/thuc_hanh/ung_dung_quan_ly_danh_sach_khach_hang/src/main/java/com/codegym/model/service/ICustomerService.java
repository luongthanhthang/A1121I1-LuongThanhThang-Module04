package com.codegym.model.service;

import com.codegym.model.entity.Customer;

import java.util.List;

public interface ICustomerService {
    void create(Customer customer);
    void update(Customer customer);
    void delete(String id);
    List<Customer> findAll();
    Customer findById(String id);
}
