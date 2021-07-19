package com.example.ormdemo.service;

import com.example.ormdemo.entity.Product;
import com.example.ormdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductService(){}

    public List<Product> getAllProducts(){

        return (List<Product>) productRepository.findAll();
    }

    public Product getProductWithId(int id){

        return productRepository.findById(id).orElse(null);
    }

    public String saveProduct(Product product){
        productRepository.save(product);
        return "Customer Saved";

    }

    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "Record Deleted with id : "+id;
    }
}
