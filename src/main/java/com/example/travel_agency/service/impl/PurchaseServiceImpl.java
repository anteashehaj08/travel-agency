package com.example.travel_agency.service.impl;

import com.example.travel_agency.dtos.PurchaseRequestDto;
import com.example.travel_agency.entities.PurchasingTour;
import com.example.travel_agency.entities.Tour;
import com.example.travel_agency.exceptions.TourException;
import com.example.travel_agency.repositories.PurchaseRepository;
import com.example.travel_agency.repositories.TourRepository;
import com.example.travel_agency.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    TourRepository tourRepository;


    @Override
    public PurchasingTour purchase(PurchaseRequestDto purchaseDto){
        PurchasingTour purchasedTour = PurchaseRequestDto.toEntity(purchaseDto);
        purchaseDto.setTour(purchaseDto.getTour());
        purchaseDto.setNumOfAdults(purchaseDto.getNumOfAdults());
        purchaseDto.setNumOfChildren(purchaseDto.getNumOfChildren());
        Tour tour = new Tour();
        Double totalAmount=purchaseDto.getNumOfAdults()*tour.getPriceForAdult()
                +purchaseDto.getNumOfChildren()*tour.getPriceForChild();
        purchaseDto.setTotalAmount(totalAmount);
        return purchaseRepository.save(purchasedTour);
    }
    @Override
    public PurchasingTour updatePurchase(Long purchaseId, PurchaseRequestDto dto) {
        PurchasingTour purchase = purchaseRepository.findById(purchaseId)
                .orElseThrow(() -> TourException.idDoesNotExist("Purchase"));
        purchase.setNumberOfAdults(dto.getNumOfAdults());
        purchase.setNumberOfChildren(dto.getNumOfChildren());

        Tour tour = purchase.getTour();
        double total = dto.getNumOfAdults() * tour.getPriceForAdult()
                + dto.getNumOfChildren() * tour.getPriceForChild();

        purchase.setTotalAmount(total);

        return purchaseRepository.save(purchase);
    }
}
