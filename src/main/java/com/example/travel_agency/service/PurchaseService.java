package com.example.travel_agency.service;

import com.example.travel_agency.dtos.PurchaseRequestDto;
import com.example.travel_agency.entities.PurchasingTour;

import java.util.List;
import java.util.Optional;

public interface PurchaseService {
    List<PurchasingTour> findAll();

    Optional<PurchasingTour> findById(Long id);

    PurchasingTour purchase(PurchaseRequestDto purchaseDto);

    PurchasingTour updatePurchase(Long purchaseId, PurchaseRequestDto purchaseDto);

    List<PurchaseRequestDto> getRecentPurchases();
}
