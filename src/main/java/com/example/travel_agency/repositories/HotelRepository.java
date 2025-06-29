package com.example.travel_agency.repositories;

import com.example.travel_agency.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
List<Hotel> findAllByCity_Id(Long cityId);

}
