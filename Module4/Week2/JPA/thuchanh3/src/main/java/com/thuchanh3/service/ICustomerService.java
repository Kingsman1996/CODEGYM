package com.thuchanh3.service;

import com.thuchanh3.model.Customer;

public interface ICustomerService {
    boolean saveWithStoredProcedure(Customer customer);
}
