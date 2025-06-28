package com.example.travel_agency.repositories;

import com.example.travel_agency.entities.PurchasingTour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<PurchasingTour,Long> {
}
