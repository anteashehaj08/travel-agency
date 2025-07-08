package com.example.travel_agency.controllers;


import com.example.travel_agency.dtos.TourFilterDto;
import com.example.travel_agency.dtos.TourRequestDto;
import com.example.travel_agency.dtos.TourResponseDto;
import com.example.travel_agency.entities.Continent;
import com.example.travel_agency.entities.Tour;
import com.example.travel_agency.repositories.TourRepository;
import com.example.travel_agency.service.ContinentService;
import com.example.travel_agency.service.TourService;
import com.example.travel_agency.statics.TourType;
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
    private TourRepository tourRepository;

    @Autowired
    private TourService tourService;

    @Autowired
    private ContinentService continentService;

    @GetMapping
    public String tours(Model model) {
        List<Tour> tours = tourService.findAll();
        List<Continent> continents = continentService.findAll();
        model.addAttribute("tours", tours);
        model.addAttribute("continents", continents);
        return "tours/home";
    }

    @GetMapping("/new")
    public String newTourPage(Model model) {
        model.addAttribute("tour", new TourRequestDto());
        model.addAttribute("types", TourType.values());
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

    @GetMapping("/search")
    public String searchForm(Model model) {
        model.addAttribute("searchParam", "");
        return "tours/search";
    }

    @GetMapping("/details/{id}")
    public String getTourDetails(@PathVariable Long id, Model model) {
        Tour tour = tourService.findTourById(id);
        if (tour == null) {
            return "redirect:/tours";
        }
        model.addAttribute("tour", tour);
        return "tours/details";
    }

    @PostMapping("/search/continent")
    public String searchToursByContinent(@RequestParam("continent") String continent, Model model) {
        List<Tour> tours = tourRepository.findByContinent(continent);
        List<TourResponseDto> tourDtos = tours.stream()
                .map(TourResponseDto::toDto)
                .collect(Collectors.toList());

        model.addAttribute("searchParam", continent);
        model.addAttribute("tours", tourDtos);
        return "tours/search-results";
    }
    @PostMapping("/search/country")
    public String searchToursByCountry(@RequestParam("country") String country, Model model) {
        List<Tour> tours = tourRepository.findByCountry(country);
        List<TourResponseDto> tourDtos = tours.stream()
                .map(TourResponseDto::toDto)
                .collect(Collectors.toList());

        model.addAttribute("searchParam", country);
        model.addAttribute("tours", tourDtos);
        return "tours/search-results";
    }
    @PostMapping("/search/city")
    public String searchToursByCity(@RequestParam("city") String city, Model model) {
        List<Tour> tours = tourRepository.findByCity(city);
        List<TourResponseDto> tourDtos = tours.stream()
                .map(TourResponseDto::toDto)
                .collect(Collectors.toList());

        model.addAttribute("searchParam", city);
        model.addAttribute("tours", tourDtos);
        return "tours/search-results";
    }
    @PostMapping("/search/hotel")
    public String searchToursByHotel(@RequestParam("hotel") String hotel, Model model) {
        List<Tour> tours = tourRepository.findByHotel(hotel);
        List<TourResponseDto> tourDtos = tours.stream()
                .map(TourResponseDto::toDto)
                .collect(Collectors.toList());

        model.addAttribute("searchParam", hotel);
        model.addAttribute("tours", tourDtos);
        return "tours/search-results";
    }

}