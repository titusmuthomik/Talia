package com.loan.talia.service;

import com.loan.talia.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    
    List<Customer> getAllCustomers();

    Customer getCustomerById(String id);

    Customer updateCustomer(String id);

    String deleteCustomer(String id);
}
