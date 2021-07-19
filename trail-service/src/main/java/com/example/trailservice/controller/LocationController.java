package com.example.trailservice.controller;

import com.example.trailservice.entity.Location;
import com.example.trailservice.service.LocationService;
import com.example.trailservice.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/save")
    public Location saveLocation(@RequestBody Location location){
        return locationService.saveLocation(location);
    }

    @GetMapping("/find/{id}")
    public ResponseTemplateVO getLocationWithCustomer(@PathVariable("id") int id){
        return locationService.getLocationWithCustomer(id);
    }

}
