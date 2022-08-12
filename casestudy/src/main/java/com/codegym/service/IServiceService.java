package com.codegym.service;


import com.codegym.entity.Employee;
import com.codegym.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IServiceService {
    Page<Service> findAllService(Pageable pageable);

    List<Service> findAllList();

    Page<Service> searchService(String nameSearch, String standardRoomSearch, Pageable pageable);

    void insertService(Service service);

    void deleteService(Integer id);

    void updateService(Service service);

    Service selectService(Integer id);
}
