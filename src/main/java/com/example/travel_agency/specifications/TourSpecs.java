package com.example.travel_agency.specifications;

import com.example.travel_agency.dtos.TourFilterDto;
import com.example.travel_agency.entities.Tour;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class TourSpecs {
        public static Specification<Tour> filter(TourFilterDto filterDTO) {
            return (root, query, cb) -> {
                List<Predicate> predicates = new ArrayList<>();
                if (filterDTO.getContinentEnum() != null) {
                    predicates.add(cb.equal(root.get("continent"), filterDTO.getContinentEnum()));
                }
                if (filterDTO.getArrivalCountryId() != null) {
                    predicates.add(cb.equal(root.get("arrival_country"), filterDTO.getArrivalCountryId()));
                }
                if (filterDTO.getArrivalCityId() != null) {
                    predicates.add(cb.equal(root.get("arrival_city"), filterDTO.getArrivalCityId()));
                }
                if (filterDTO.getArrivalHotelId() != null) {
                    predicates.add(cb.equal(root.get("arrival_hotel"), filterDTO.getArrivalHotelId()));
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            };
        }
    }