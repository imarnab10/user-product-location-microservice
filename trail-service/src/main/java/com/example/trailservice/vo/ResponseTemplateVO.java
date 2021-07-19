package com.example.trailservice.vo;

import com.example.trailservice.entity.Location;
import org.springframework.stereotype.Component;

public class ResponseTemplateVO {
    private Location location;
    private Customer customer;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
