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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    TourRepository tourRepository;

    @Override
    public List<PurchasingTour> findAll(){
        return purchaseRepository.findAll();
    }

    @Override
    public Optional<PurchasingTour> findById(Long id){
        return purchaseRepository.findById(id);
    }

    @Override
    public PurchasingTour purchase(PurchaseRequestDto purchaseDto){
        Tour tour = tourRepository.findById(purchaseDto.getTourId()).orElseThrow();
        if (purchaseDto.getNumOfChildren()+purchaseDto.getNumOfAdults()<=tour.getNumberOfPlaces()){
            PurchasingTour purchasedTour = PurchaseRequestDto.toEntity(purchaseDto);
            purchasedTour.setTour(tour);
            Double totalAmount=(purchaseDto.getNumOfAdults()*tour.getPriceForAdult())
                    +(purchaseDto.getNumOfChildren()*tour.getPriceForChild());
            purchasedTour.setTotalAmount(totalAmount);
            tour.setNumberOfPlaces(tour.getNumberOfPlaces()-(purchaseDto.getNumOfChildren()+purchaseDto.getNumOfAdults()));
            return purchaseRepository.save(purchasedTour);
        }
        else {
            throw TourException.notEnoughPlaces();
        }
        }

    @Override
    public PurchasingTour updatePurchase(Long purchaseId, PurchaseRequestDto purchaseDto) {
        PurchasingTour existingPurchase = purchaseRepository.findById(purchaseId)
                .orElseThrow(() -> TourException.idDoesNotExist("Purchase"));

        Tour tour = tourRepository.findById(purchaseDto.getTourId())
                .orElseThrow(() -> TourException.idDoesNotExist("Tour"));

        int updatedNumOfPeople = purchaseDto.getNumOfAdults() + purchaseDto.getNumOfChildren();
        int currentNumOfPeople = existingPurchase.getNumberOfAdults() + existingPurchase.getNumberOfChildren();
        int availableSpots = tour.getNumberOfPlaces() + currentNumOfPeople;

        if (updatedNumOfPeople <= availableSpots) {
            existingPurchase.setNumberOfAdults(purchaseDto.getNumOfAdults());
            existingPurchase.setNumberOfChildren(purchaseDto.getNumOfChildren());
            existingPurchase.setTour(tour);

            double totalAmount = (purchaseDto.getNumOfAdults() * tour.getPriceForAdult())
                    + (purchaseDto.getNumOfChildren() * tour.getPriceForChild());
            existingPurchase.setTotalAmount(totalAmount);

            tour.setNumberOfPlaces(availableSpots - updatedNumOfPeople);

            return purchaseRepository.save(existingPurchase);
        } else {
            throw TourException.notEnoughPlaces();
        }
    }

    @Override
    public List<PurchaseRequestDto> getRecentPurchases() {
        return purchaseRepository.findTop10ByOrderByTourDepartureDateDesc()
                .stream()
                .map(purchase -> {
                    PurchaseRequestDto dto = new PurchaseRequestDto();
                    dto.setId(purchase.getId());
                    dto.setTourDepartureDate(purchase.getTour().getDepartureDate());
                    return dto;
                })
                .collect(Collectors.toList());
    }


}
