package com.codegym.service;


import com.codegym.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);
    void insert(Contract contract);
}
