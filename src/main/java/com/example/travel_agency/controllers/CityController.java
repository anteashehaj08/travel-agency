package com.example.travel_agency.controllers;

import com.example.travel_agency.entities.City;
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
    @GetMapping
    public String listCities(Model model) {
        model.addAttribute("cities", cityService.getAllCities());
        return "cities/city_list";
    }
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("city", new City());
        return "cities/city_form";
    }

    @PostMapping
    public String createCity(@ModelAttribute City city) {
        cityService.createCity(city.getName(), city.getNationality().getCountryId());
        return "redirect:/cities";
    }

    @GetMapping("/{id}")
    public String viewCity(@PathVariable Long id, Model model) {
        model.addAttribute("city", cityService.getCityById(id));
        return "cities/city_details";
    }

}

