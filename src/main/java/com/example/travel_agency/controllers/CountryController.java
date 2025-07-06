package com.example.travel_agency.controllers;

import com.example.travel_agency.entities.Country;
import com.example.travel_agency.repositories.CountryRepository;
import com.example.travel_agency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/countries")
public class CountryController {
    @Autowired
    public CountryService countryService;


    @PostMapping("/update")
    public String create(@ModelAttribute("country") Country country) {
        countryService.updateCountry(country.getName(), country.getCountryId(), country.getContinentMembership().getId());
        return "redirect:/countries";
    }

    @GetMapping("/find/{id}")
    public String findById(@PathVariable Long countryId, Model model) {
        model.addAttribute("country", countryService.getCountryById(countryId));
        return "/country/countries";
    }
}
