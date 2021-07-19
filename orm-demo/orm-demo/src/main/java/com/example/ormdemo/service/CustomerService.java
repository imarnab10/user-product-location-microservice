package com.example.ormdemo.service;

import com.example.ormdemo.entity.Customer;
import com.example.ormdemo.entity.Product;
import com.example.ormdemo.repository.CustomerRepository;
import com.example.ormdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    public List<Customer> getAllCustomers(){
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer getCustomerWithId(int id){
        return customerRepository.findById(id).orElse(null);
    }

    public String saveCustomer(Customer customer){
        customerRepository.save(customer);
        return "Customer Saved";

    }

    public Customer addCustomerWithProducts(Customer customer){
        customer.setId(customer.getId());
        customer.setCustomerName(customer.getCustomerName());
        customer.setEmail(customer.getEmail());
        customer.setProducts(customer.getProducts()
		  .stream() .map(product -> { 
			  Product prod = product; 
			  if(prod.getId() > 0){
				  prod = productRepository.findById(prod.getId()).orElse(null); 
			  }
		  prod.addCustomer(customer); return prod; 
		  }) .collect(Collectors.toSet())
		 );
        return customerRepository.save(customer);
    }

}
