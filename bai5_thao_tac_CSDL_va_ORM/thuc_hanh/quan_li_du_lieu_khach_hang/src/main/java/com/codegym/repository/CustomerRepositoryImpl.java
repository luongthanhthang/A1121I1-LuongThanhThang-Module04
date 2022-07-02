package com.codegym.repository;

import com.codegym.entity.Customer;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
@EnableTransactionManagement
public class CustomerRepositoryImpl implements ICustomerRepository {

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public void create(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public void delete(String id) {
        Customer customer = findById(id);
        entityManager.remove(customer);
    }

    @Override
    public List<Customer> findAll() {
        // HQL
        List<Customer> customerList = entityManager
                .createQuery("select c from Customer c")
                .getResultList();
        // Native SQL
//        students = entityManager
//                .createNativeQuery("select * from Student")
//                .getResultList();
        return customerList;
    }

    @Override
    public Customer findById(String id) {
        return entityManager.find(Customer.class, id);
    }
}
