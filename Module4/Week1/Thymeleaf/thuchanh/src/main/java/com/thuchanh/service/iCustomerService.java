package com.thuchanh.service;

import com.thuchanh.model.Customer;

import java.util.List;

public interface iCustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}