package com.example.travel_agency.repositories;

import com.example.travel_agency.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour,Long> {
}
