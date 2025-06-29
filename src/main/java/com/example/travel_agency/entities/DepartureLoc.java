package com.example.travel_agency.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class DepartureLoc {
    @ManyToOne(optional = false)
    private City city;
    @ManyToOne(optional = false)
    private Airport airport;
}
