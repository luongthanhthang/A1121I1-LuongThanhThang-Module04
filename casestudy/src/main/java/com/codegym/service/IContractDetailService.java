package com.codegym.service;


import com.codegym.entity.ContractDetail;

import java.util.List;


public interface IContractDetailService {
    List<ContractDetail> findAll();
    void insert(ContractDetail contractDetail);
}
