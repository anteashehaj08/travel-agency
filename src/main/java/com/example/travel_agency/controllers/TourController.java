package com.example.travel_agency.controllers;


import com.example.travel_agency.dtos.TourFilterDto;
import com.example.travel_agency.entities.Tour;
import com.example.travel_agency.repositories.TourRepository;
import com.example.travel_agency.specifications.TourSpecs;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tours")
public class TourController {

    private final TourRepository tourRepository;

    public TourController(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @GetMapping("/tours/filter")
    public Tour filterTours(@ModelAttribute TourFilterDto filterDTO, Model model) {
    }
}