package com.service;

import com.model.Customer;
import com.model.Province;
import com.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public Iterable<Customer> findAllByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }
}
