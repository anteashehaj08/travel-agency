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
    @Embedded
    @AssociationOverrides({
            @AssociationOverride(name = "airport", joinColumns = @JoinColumn(name = "departure_airport_id")),
            @AssociationOverride(name = "city", joinColumns = @JoinColumn(name = "departure_city_id"))
    })
    private DepartureLoc whereFrom;

    @Embedded
    @AssociationOverrides({
            @AssociationOverride(name = "airport", joinColumns = @JoinColumn(name = "arrival_airport_id")),
            @AssociationOverride(name = "city", joinColumns = @JoinColumn(name = "arrival_city_id")),
            @AssociationOverride(name = "hotel", joinColumns = @JoinColumn(name = "arrival_hotel_id"))
    })
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
