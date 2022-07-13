package com.codegym.repository;

import com.codegym.entity.Customer;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, String> {

    @Query(value = "select customer_id, name, email, address from customer where name like :nameCustomer", nativeQuery = true)
    Page<Customer> search(@Param("nameCustomer") String name, Pageable pageable);

    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
