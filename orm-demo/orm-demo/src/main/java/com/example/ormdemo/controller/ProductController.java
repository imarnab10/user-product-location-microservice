package com.example.ormdemo.controller;

import com.example.ormdemo.entity.Product;
import com.example.ormdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return (List<Product>) productService.getAllProducts();
    }

    @GetMapping("product/{id}")
    public Product getProductWithId(@PathVariable int id){
        return productService.getProductWithId(id);
    }

    @PostMapping("/product/save")
    public void saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
    }

    @DeleteMapping("/product/delete/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }
}
