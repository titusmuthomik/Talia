package com.loan.talia.controller;

import com.loan.talia.entity.CustomerEntity;
import com.loan.talia.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;



    @PostMapping
    public ResponseEntity<CustomerEntity> save(@RequestBody CustomerEntity customer) {
        CustomerEntity newCustomer = customerService.save(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable Long id){
        CustomerEntity customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        List<CustomerEntity> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public CustomerEntity updateCustomer(@PathVariable Long id, @RequestBody CustomerEntity customer) {
        CustomerEntity existingCustomer = customerService.updateCustomer(id, customer);
        return new ResponseEntity<>(existingCustomer, HttpStatus.OK).getBody();
    }

    @DeleteMapping("/{id}")
    public  String deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }
}
