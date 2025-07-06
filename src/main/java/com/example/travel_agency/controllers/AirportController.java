package com.example.travel_agency.controllers;

import com.example.travel_agency.entities.Airport;
import com.example.travel_agency.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/airports")
public class AirportController {
@Autowired
    private AirportService airportService;
@PostMapping("/create")
    public String createAirport(@ModelAttribute("airport") Airport airport){
    airportService.createAirport(airport.getAirportId(), airport.getName());
    return "redirect:/airports";
}
@GetMapping("/find/{id}")
    public String editAirport(@PathVariable Long id, Model model){
    model.addAttribute("airport",airportService.findById(id));
    return "/airports/airport_details";
}
}
