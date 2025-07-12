package com.example.travel_agency.controllers;

import com.example.travel_agency.dtos.PurchaseRequestDto;
import com.example.travel_agency.entities.PurchasingTour;
import com.example.travel_agency.exceptions.TourException;
import com.example.travel_agency.service.PurchaseService;
import com.example.travel_agency.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private TourService tourService;
    @GetMapping
    public String listPurchases(Model model) {
        List<PurchaseRequestDto> purchases = purchaseService.getRecentPurchases();
        model.addAttribute("purchases", purchases);
        return "purchases/list";
    }

    @GetMapping("/new")
    public String showCreateForm(@RequestParam(required = false) Long tourId, Model model) {
        PurchaseRequestDto dto = new PurchaseRequestDto();
        if (tourId != null) {
            dto.setTourId(tourId);
        }
        model.addAttribute("purchaseRequestDto", dto);
        model.addAttribute("tours", tourService.findAll());
        return "purchases/create";
    }


    @PostMapping
    public String createPurchase(@ModelAttribute("purchaseRequestDto") PurchaseRequestDto purchaseDto
            , BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("tours", tourService.findAll());
            return "purchases/create";
        }
        purchaseService.purchase(purchaseDto);
        return "redirect:/purchases";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        PurchasingTour purchase = purchaseService.findById(id)
                .orElseThrow(()-> TourException.idDoesNotExist("Purchase"));
        PurchaseRequestDto dto = new PurchaseRequestDto();
        dto.setId(purchase.getId());
        dto.setNumOfAdults(purchase.getNumberOfAdults());
        dto.setNumOfChildren(purchase.getNumberOfChildren());
        dto.setTourId(purchase.getTour().getId());
        model.addAttribute("purchaseRequestDto", dto);
        model.addAttribute("tours", tourService.findAll());
        return "purchases/edit";
    }

    @PostMapping("/update/{id}")
    public String updatePurchase(@PathVariable Long id,
                                 @ModelAttribute("purchaseRequestDto") PurchaseRequestDto purchaseDto,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("tours", tourService.findAll());
            return "purchases/edit";
        }
        purchaseService.updatePurchase(id, purchaseDto);
        return "redirect:/purchases";
    }
}
