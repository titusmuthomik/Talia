package com.loan.talia.service;

import com.loan.talia.entity.CustomerEntity;
import com.loan.talia.exception.CustomException;
import com.loan.talia.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImplementation implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerEntity save(CustomerEntity customer) {

        customerRepository.save(customer);
        return customer;
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();

    }

    @Override
    public CustomerEntity getCustomerById(Long id) {
        Optional<CustomerEntity> customer = Optional.ofNullable(customerRepository.findById(id).orElseThrow(() -> new CustomException("That customer could not be found", "NOT_FOUND", 404)));

        return customer.get();
    }

    @Override
    public CustomerEntity updateCustomer(Long id, CustomerEntity updatedCustomer) {
        CustomerEntity existingCustomerEntity = customerRepository.findById(id)
                .orElseThrow(() -> new CustomException("A customer with id" + id + "could not be found in the database", "NOT_FOUND", 404));

        existingCustomerEntity.setFirstName(updatedCustomer.getFirstName());
        existingCustomerEntity.setLastName(updatedCustomer.getLastName());
        existingCustomerEntity.setNationalId(updatedCustomer.getNationalId());

        customerRepository.save(existingCustomerEntity);

        return existingCustomerEntity;
    }

    @Override
    public String deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        return "Customer with id" + id + " was successfully deleted";
    }

//
//    @Override
//    public Customer save(Customer customer) {
//        if(customer.getCustomerId() == null) {
//            String customerId = UUID.randomUUID().toString();
//            customer.setCustomerId(customerId);
//        }
//
//        customers.add(customer);
//
//        return customer;
//    }
//
//    @Override
//    public List<Customer> getAllCustomers() {
//        return  customers;
//    }
//
//    @Override
//    public Customer getCustomerById(String id) {
////        for(Customer customer : customers) {
////            if(customer.getCustomerId().equalsIgnoreCase(id)) {
////                return customer;
////            }
////        }
////        return  null;
//
//        return customers.stream()
//                .filter(customerFilter -> customerFilter.getCustomerId().equalsIgnoreCase(id))
//                .findFirst()
//                .orElseThrow( () -> new  NullPointerException("No customer found with the id " + id));
//    }
//
//    @Override
//    public Customer updateCustomer(String id, Customer updatedCustomer) {
//        Customer customer = customers.stream()
//                .filter(customerFilter -> customerFilter.getCustomerId().equalsIgnoreCase(id))
//                .findFirst()
//                .orElseThrow( () -> new  NullPointerException("No customer found with the id " + id));
//        customer.setFirstName(updatedCustomer.getFirstName());
//        customer.setLastName(updatedCustomer.getLastName());
//
//        return customer;
//    }
//
//    @Override
//    public String deleteCustomer(String id) {
//        for(Customer customer : customers) {
//            if(customer.getCustomerId().equalsIgnoreCase(id)) {
//                customers.remove(customer);
//                return "Customer deleted successfully";
//            }
//        }
//        return "No customer found with the above Id";
//    }


}
