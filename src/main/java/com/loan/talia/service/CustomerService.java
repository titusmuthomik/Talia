package com.loan.talia.service;

import com.loan.talia.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {
    CustomerEntity save(CustomerEntity customer);

    List<CustomerEntity> getAllCustomers();

    CustomerEntity getCustomerById(Long id);

    CustomerEntity updateCustomer(Long id, CustomerEntity customer);

    String deleteCustomer(Long id);
}
