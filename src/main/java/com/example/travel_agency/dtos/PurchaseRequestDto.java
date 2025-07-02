package com.example.travel_agency.dtos;

import com.example.travel_agency.entities.PurchasingTour;
import com.example.travel_agency.entities.Tour;
import lombok.Data;

@Data
public class PurchaseRequestDto {
    private Long id;
    private Tour tour;
    private Integer numOfAdults;
    private Integer numOfChildren;
    private Double totalAmount;

    public static PurchasingTour toEntity(PurchaseRequestDto purchaseDto){
        return PurchasingTour.builder()
                .id(purchaseDto.getId())
                .tour(purchaseDto.getTour())
                .numberOfAdults(purchaseDto.getNumOfAdults())
                .numberOfChildren(purchaseDto.getNumOfChildren())
                .totalAmount(purchaseDto.getTotalAmount())
                .build();
    }
}
