package com.codegym.service.impl;

import com.codegym.entity.Employee;
import com.codegym.repository.IEmployeeRepository;
import com.codegym.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;


    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findAllList() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> search(String nameSearch, String emailSearch, String divisionSearch, Pageable pageable) {
        return employeeRepository.search("%" + nameSearch + "%", "%" + emailSearch + "%", "%" + divisionSearch + "%", pageable);
    }

    @Override
    public void insert(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee selectEmployee(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
