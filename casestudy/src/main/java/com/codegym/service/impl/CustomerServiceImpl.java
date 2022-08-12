package com.codegym.service.impl;


import com.codegym.entity.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findAllList() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> searchCustomer(String nameSearch, String emailSearch, String typeSearch, Pageable pageable) {
        return customerRepository.searchCustomer("%" + nameSearch + "%", "%" + emailSearch + "%", "%" + typeSearch + "%", pageable);
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer selectCustomer(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }
}
