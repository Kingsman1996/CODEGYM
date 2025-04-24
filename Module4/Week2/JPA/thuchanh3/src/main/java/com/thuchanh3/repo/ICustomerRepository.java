package com.thuchanh3.repo;

import com.thuchanh3.model.Customer;


public interface ICustomerRepository {
    boolean saveWithStoredProcedure(Customer customer);
}
