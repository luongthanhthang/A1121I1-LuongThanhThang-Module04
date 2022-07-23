package com.codegym.service;

import com.codegym.entity.Factory;
import com.codegym.repository.IFactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IFactoryServiceImpl implements IFactoryService {
    @Autowired
    IFactoryRepository factoryRepository;

    @Override
    public void create(Factory factory) {
        factoryRepository.save(factory);
    }

    @Override
    public void update(Factory factory) {
        factoryRepository.save(factory);
    }

    @Override
    public void delete(int id) {
        factoryRepository.deleteById(id);
    }

    @Override
    public List<Factory> findAll() {
        return factoryRepository.findAll();
    }

    @Override
    public Factory findById(int id) {
        return factoryRepository.findById(id).orElse(null);
    }
}
