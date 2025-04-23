package com.thuchanh.service;

import com.thuchanh.model.Customer;

import java.util.List;

public interface ICustomerDAO {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void remove(int id);
}
