package com.codegym.service.impl;


import com.codegym.entity.ServiceType;
import com.codegym.repository.IServiceTypeRepository;
import com.codegym.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository serviceRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceRepository.findAll();
    }
}
