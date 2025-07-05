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
        Tour tour = new Tour();
        if (purchaseDto.getNumOfChildren()+purchaseDto.getNumOfAdults()>tour.getNumberOfPlaces()){
            PurchasingTour purchasedTour = PurchaseRequestDto.toEntity(purchaseDto);
            purchaseDto.setTour(purchaseDto.getTour());
            purchaseDto.setNumOfAdults(purchaseDto.getNumOfAdults());
            purchaseDto.setNumOfChildren(purchaseDto.getNumOfChildren());
            Double totalAmount=purchaseDto.getNumOfAdults()*tour.getPriceForAdult()
                    +purchaseDto.getNumOfChildren()*tour.getPriceForChild();
            purchaseDto.setTotalAmount(totalAmount);
            tour.setNumberOfPlaces(tour.getNumberOfPlaces()-(purchaseDto.getNumOfChildren()+purchaseDto.getNumOfAdults()));
            return purchaseRepository.save(purchasedTour);
        }
        else {
            throw TourException.notEnoughPlaces();
        }
        }

}
