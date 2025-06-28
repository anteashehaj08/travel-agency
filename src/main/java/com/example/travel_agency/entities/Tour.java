package com.example.travel_agency.entities;

import com.example.travel_agency.statics.TourType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tours")
@Data
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private DepartureLocation whereFrom;
    private ArrivalLoc whereTo;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private Integer duration;
    private TourType type;
    private Double priceForAdult;
    private Double priceForChild;
    private Boolean promoted;
    private Integer numberOfPlaces;


}
