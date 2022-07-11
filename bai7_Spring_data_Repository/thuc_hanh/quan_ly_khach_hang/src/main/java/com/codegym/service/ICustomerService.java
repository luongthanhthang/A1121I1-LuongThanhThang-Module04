package com.codegym.service;

import com.codegym.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    void create(Customer customer);
    void update(Customer customer);
    void delete(String id);
    Page<Customer> findAll(Pageable pageable);
    Customer findById(String id);
    Page<Customer> search(String name, Pageable pageable);
}
