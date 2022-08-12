package com.codegym.repository;

import com.codegym.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Service, Integer> {
    @Query(value = "select * from SERVICE where `name` like ?1 and standard_room like ?2", nativeQuery = true)
    Page<Service> search(String name, String standard_room, Pageable pageable);
}
