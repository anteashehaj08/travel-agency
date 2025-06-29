package com.example.travel_agency.entities;

import com.example.travel_agency.statics.TourType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tours")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private DepartureLoc whereFrom;
    private ArrivalLoc whereTo;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private Integer duration;
    @Enumerated(EnumType.STRING)
    private TourType type;
    private Double priceForAdult;
    private Double priceForChild;
    private Boolean promoted;
    private Integer numberOfPlaces;


}
