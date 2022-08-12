package com.codegym.service.impl;


import com.codegym.entity.Service;
import com.codegym.repository.IServiceRepository;
import com.codegym.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {
    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public Page<Service> findAllService(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public List<Service> findAllList() {
        return serviceRepository.findAll();
    }

    @Override
    public Page<Service> searchService(String nameSearch, String standardRoomSearch, Pageable pageable) {
        return serviceRepository.search("%" + nameSearch + "%", standardRoomSearch, pageable);
    }

    @Override
    public void insertService(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void deleteService(Integer id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public void updateService(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Service selectService(Integer id) {
        return serviceRepository.findById(id).orElse(null);
    }


}
