package com.example.travel_agency.controllers_thymeleaf;

import com.example.travel_agency.entities.Airport;
import com.example.travel_agency.repositories.AirportRepository;
import com.example.travel_agency.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/airports")
public class AirportControllerThymeleaf {
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private AirportService airportService;
  //  @GetMapping("/airports")
  //  public Airport airport(Model model) {
   //     model.addAttribute("airports", airportRepository.findAll());
   //     return ;
  //  }
 @GetMapping("/airports")
 public String getAirportDetails(@PathVariable String name, Model model) {
      Airport airport = airportRepository.findByName(name)
              .orElseThrow(() -> new IllegalArgumentException("Invalid airport name: " + name));
      model.addAttribute("airports", airport);
      return "airport_details";
  }



    @PostMapping("/save")
    public String createAirport(@ModelAttribute("airport") Airport airport) {
        airportService.create(airport);
        return "save";
    }
}
