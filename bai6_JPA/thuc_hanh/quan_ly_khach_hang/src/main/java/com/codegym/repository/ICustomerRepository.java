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

    @Query(value ="select customer_id, name, email, address from customer where name like :nameCustomer", nativeQuery = true)
    List<Customer> search(@Param("nameCustomer") String name);

    @Modifying
    @Query(value = "call insert_customer(:customer_id, :name, :email, :address)", nativeQuery = true)
    void insertCustomerProcedure(@Param("customer_id") String id, @Param("name") String name, @Param("email") String email, @Param("address") String address);

//    List<Customer> findAllByNameContaining(String name);
}
