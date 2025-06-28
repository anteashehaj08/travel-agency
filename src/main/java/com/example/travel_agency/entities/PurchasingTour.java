package com.example.travel_agency.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "purchases")
public class PurchasingTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonIgnore
    private Tour tour;
    private Integer numberOfAdults;
    private Integer numberOfChildren;
    private Double totalAmount;
}
