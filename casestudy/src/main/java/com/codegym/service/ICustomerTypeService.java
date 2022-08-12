package com.codegym.service;



import com.codegym.entity.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
