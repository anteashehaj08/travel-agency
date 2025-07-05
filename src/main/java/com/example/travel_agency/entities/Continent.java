package com.example.travel_agency.entities;

import com.example.travel_agency.statics.ContinentEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "continents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ContinentEnum name;

    public Continent(String name){
        this.name=ContinentEnum.valueOf(name);
    }
}
