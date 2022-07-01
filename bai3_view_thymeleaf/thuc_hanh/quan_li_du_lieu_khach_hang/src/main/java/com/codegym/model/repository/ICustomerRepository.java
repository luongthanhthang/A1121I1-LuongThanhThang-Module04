package com.codegym.model.repository;

import com.codegym.model.entity.Customer;

import java.util.List;

public interface ICustomerRepository {
    void create(Customer student);

    void update(Customer student);

    void delete(String id);

    List<Customer> findAll();

    Customer findById(String id);
}
