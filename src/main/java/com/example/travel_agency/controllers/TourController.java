package com.example.travel_agency.controllers;


import com.example.travel_agency.dtos.TourFilterDto;
import com.example.travel_agency.dtos.TourRequestDto;
import com.example.travel_agency.dtos.TourResponseDto;
import com.example.travel_agency.entities.Tour;
import com.example.travel_agency.service.TourService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/tours")
public class TourController {
    @Autowired
    private TourService tourService;

    @GetMapping("/new")
    public String newTourPage(Model model) {
        model.addAttribute("tour", new TourRequestDto());
        return "tours/new";
    }
    @PostMapping("/save")
    public String saveTour(@Valid @ModelAttribute("tour") TourRequestDto tourRequestDto, BindingResult  bindingResult) {
        if (bindingResult.hasErrors()) {
            return "tours/new";
        }
        tourService.createTour(tourRequestDto);
        return "redirect:/tours";
    }
    @GetMapping("/edit/{id}")
    public String editTourPage(@PathVariable Long id, Model model) {
        model.addAttribute("tour", tourService.findTourById(id));
        return "tours/edit";
    }
    @PostMapping("/update")
    public String updateTour(@Valid @ModelAttribute("tour") TourRequestDto tourRequestDto) {
        tourService.updateTour(tourRequestDto);
        return "redirect:/tours";
    }

    @GetMapping("/filter")
    public String filterTourPage(Model model) {
        TourFilterDto filterDto = new TourFilterDto();
        List<Tour> tours = tourService.filter(filterDto);

        List<TourResponseDto> filteredTours = tours.stream()
                .map(TourResponseDto::toDto)
                .collect(Collectors.toList());

        model.addAttribute("tour", filteredTours);
        return "tours/filter";
    }


}