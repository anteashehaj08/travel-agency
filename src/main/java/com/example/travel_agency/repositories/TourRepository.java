package com.example.travel_agency.repositories;

import com.example.travel_agency.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour,Long>, JpaSpecificationExecutor<Tour> {
    @Query("SELECT t FROM Tour t WHERE LOWER" +
            "(t.whereTo.hotel.city.nationality.continentMembership.name) = LOWER(:continent)")
    List<Tour> findByContinent(@Param("continent") String continent);
    @Query("SELECT t FROM Tour t WHERE LOWER" +
            "(t.whereTo.hotel.city.nationality.name) = LOWER(:country)")
    List<Tour> findByCountry(@Param("country") String country);
    @Query("SELECT t FROM Tour t WHERE LOWER" +
            "(t.whereTo.hotel.city.name) = LOWER(:city)")
    List<Tour> findByCity(@Param("city") String city);
    @Query("SELECT t FROM Tour t WHERE LOWER" +
            "(t.whereTo.hotel.name) = LOWER(:hotel)")
    List<Tour> findByHotel(@Param("hotel") String hotel);
}
