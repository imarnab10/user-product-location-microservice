package com.example.trailservice.vo;


import java.io.Serializable;


public class Product implements Serializable {
    private int id;
    private String productName;
   // private Set<Customer> customers = new HashSet<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
