package com.codegym.repository;

import com.codegym.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, String> {
    @Modifying
    @Query(value ="delete from Customer where id = :id", nativeQuery = false)
    void delete(@Param("id") String id);

    @Query(value ="select id, name, email, address from Customer where name like :nameCustomer", nativeQuery = false)
    List<Customer> search(@Param("nameCustomer") String name);

//    List<Customer> findAllByNameContaining(String name);
}
