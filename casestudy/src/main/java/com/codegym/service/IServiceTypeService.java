package com.codegym.service;



import com.codegym.entity.ServiceType;

import java.util.List;

public interface IServiceTypeService {
    List<ServiceType> findAll();
}
