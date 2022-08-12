package com.codegym.repository;


import com.codegym.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where `name` like ?1 and `email` like ?2 and customer_type_id like ?3", nativeQuery = true)
    Page<Customer> searchCustomer(String name, String email, String type, Pageable pageable);
}
