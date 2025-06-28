package com.example.travel_agency.repositories;

import com.example.travel_agency.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour,Long> {
    public void createTour(Tour tour);
    public Tour updateTour(Tour tour);
    public List<Tour> findAll();

}
