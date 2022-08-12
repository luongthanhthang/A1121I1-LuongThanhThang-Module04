package com.codegym.repository;

import com.codegym.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from EMPLOYEE where `name` like ?1 and `email` like ?2 and division_id like ?3", nativeQuery = true)
    Page<Employee> search(String name, String email, String divisionId, Pageable pageable);
}
