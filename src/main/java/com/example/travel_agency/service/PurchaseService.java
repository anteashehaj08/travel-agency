package com.example.travel_agency.service;

import com.example.travel_agency.dtos.PurchaseRequestDto;
import com.example.travel_agency.entities.PurchasingTour;

public interface PurchaseService {
    PurchasingTour purchase(PurchaseRequestDto purchaseDto);

    PurchasingTour updatePurchase(Long purchaseId, PurchaseRequestDto dto);
}
