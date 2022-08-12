package com.codegym.service.impl;


import com.codegym.entity.ContractDetail;
import com.codegym.repository.IContractDetailRepository;
import com.codegym.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void insert(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
