package com.example.ormdemo.controller;

import com.example.ormdemo.entity.Customer;
import com.example.ormdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return (List<Customer>) customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerWithId(@PathVariable int id){
        return customerService.getCustomerWithId(id);
    }

    @PostMapping("/customer/save")
    public void saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
    }

    @PostMapping("/addcustomer")
    public Customer addCourse(@RequestBody Customer customer){
        return customerService.addCustomerWithProducts(customer);
    }
}
