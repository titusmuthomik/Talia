package com.loan.talia.service;

import com.loan.talia.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImplementation implements CustomerService{

    List<Customer> customers = new ArrayList<>();
    @Override
    public Customer save(Customer customer) {
        if(customer.getCustomerId() == null) {
            String customerId = UUID.randomUUID().toString();
            customer.setCustomerId(customerId);
        }

        customers.add(customer);

        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return  customers;
    }

    @Override
    public Customer getCustomerById(String id) {
//        for(Customer customer : customers) {
//            if(customer.getCustomerId().equalsIgnoreCase(id)) {
//                return customer;
//            }
//        }
//        return  null;

        return customers.stream()
                .filter(customerFilter -> customerFilter.getCustomerId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow( () -> new  NullPointerException("No customer found with the id " + id));
    }

    @Override
    public Customer updateCustomer(String id, Customer updatedCustomer) {
        Customer customer = customers.stream()
                .filter(customerFilter -> customerFilter.getCustomerId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow( () -> new  NullPointerException("No customer found with the id " + id));
        customer.setFirstName(updatedCustomer.getFirstName());
        customer.setLastName(updatedCustomer.getLastName());

        return customer;
    }

    @Override
    public String deleteCustomer(String id) {
        for(Customer customer : customers) {
            if(customer.getCustomerId().equalsIgnoreCase(id)) {
                customers.remove(customer);
                return "Customer deleted successfully";
            }
        }
        return "No customer found with the above Id";
    }


}
