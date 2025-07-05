package com.example.travel_agency.controllers;

import com.example.travel_agency.entities.City;
import com.example.travel_agency.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cities")
public class CityController {
    @Autowired
    public CityService cityService;

    @PostMapping("/create")
    public City create(@RequestBody City city) {
        return cityService.create(city);
    }
}

