package com.example.travel_agency.controllers;

import com.example.travel_agency.entities.City;
import com.example.travel_agency.repositories.CityRepository;
import com.example.travel_agency.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cities")
public class CityController {
    @Autowired
    public CityService cityService;
    @Autowired
    public CityRepository cityRepository;
    @PostMapping("/create")
    public String create(@ModelAttribute("city") City city) {
        cityService.createCity(city.getName(), city.getId());
        return "redirect:/cities";
    }
    @GetMapping("/find/{id}")
    public String editCity(@PathVariable Long id, Model model){
        model.addAttribute("city",cityRepository.findById(id));
        return "/cities/city";
    }
}

