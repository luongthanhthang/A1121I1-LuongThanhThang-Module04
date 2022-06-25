package com.codegym.model.repository;

import com.codegym.model.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {
    private static Map<String, Customer> customerMap = new HashMap<>();
    static {
        customerMap.put("SV001", new Customer("SV001", "Hoàng", "111", "Da Nang"));
        customerMap.put("SV002", new Customer("SV002", "Lan", "222", "Da Nang"));
        customerMap.put("SV003", new Customer("SV003", "Nam", "333", "Da Nang"));
        customerMap.put("SV004", new Customer("SV004", "Thuy", "444", "Da Nang"));
        customerMap.put("SV005", new Customer("SV005", "Manh", "555", "Da Nang"));
    }
    @Override
    public void create(Customer customer) {
        if (!customerMap.containsKey(customer.getId())) {
            customerMap.put(customer.getId(), customer);
        }
    }

    @Override
    public void update(Customer customer) {
        if (customerMap.containsKey(customer.getId())) {
            customerMap.put(customer.getId(), customer);
        }
    }

    @Override
    public void delete(String id) {
        if (customerMap.containsKey(id)) {
            customerMap.remove(id);
        }
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer findById(String id) {
        return customerMap.get(id);
    }
}
