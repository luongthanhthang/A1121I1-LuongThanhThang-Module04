package com.codegym.repository;



import com.codegym.entity.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {

}
