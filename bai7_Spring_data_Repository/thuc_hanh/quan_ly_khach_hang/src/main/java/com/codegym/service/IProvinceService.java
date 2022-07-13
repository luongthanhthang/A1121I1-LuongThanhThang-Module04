package com.codegym.service;

import com.codegym.entity.Province;

import java.util.List;
import java.util.Optional;

public interface IProvinceService {
    List<Province> findAll();
    Optional<Province> findById(Integer id);
}
