package com.codegym.service;

import com.codegym.entity.Customer;
import com.codegym.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findAllList();
    Page<Employee> search(String nameSearch, String emailSearch, String divisionSearch, Pageable pageable);
    void insert(Employee employee);
    void delete(Integer id);
    void update(Employee employee);
    Employee selectEmployee(Integer id);
}
