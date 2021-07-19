package com.example.trailservice.service;

import com.example.trailservice.entity.Location;
import com.example.trailservice.repository.LocationRepository;
import com.example.trailservice.vo.Customer;
import com.example.trailservice.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Location saveLocation(Location location){
        return locationRepository.save(location);
    }

    public ResponseTemplateVO getLocationWithCustomer(int id){
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Location location = locationRepository.getById(id);
        Customer customer = restTemplate.getForObject("http://localhost:8080/customer/"+location.getCustomerId(),
                Customer.class);
        vo.setLocation(location);
        vo.setCustomer(customer);
        return vo;
    }

}
