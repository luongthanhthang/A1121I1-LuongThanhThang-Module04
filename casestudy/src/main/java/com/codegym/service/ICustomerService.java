package com.codegym.service;

import com.codegym.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICustomerService {
    Page<Customer> findAllCustomer(Pageable pageable);
    List<Customer> findAllList();
    Page<Customer> searchCustomer(String nameSearch, String emailSearch, String typeSearch, Pageable pageable);
    void insertCustomer(Customer customer);
    void deleteCustomer(Integer id);
    void updateCustomer(Customer customer);
    Customer selectCustomer(Integer id);
}
