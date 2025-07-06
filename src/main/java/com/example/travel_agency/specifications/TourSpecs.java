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
                if (filterDTO.getDepartureCityId() != null) {
                    predicates.add(cb.equal(root.get("whereFromCity"), filterDTO.getDepartureCityId()));
                }
                if (filterDTO.getDepartureAirportId() != null) {
                    predicates.add(cb.equal(root.get("whereFromAirport"), filterDTO.getDepartureAirportId()));
                }
                if (filterDTO.getArrivalCityId() != null) {
                    predicates.add(cb.equal(root.get("whereToCity"), filterDTO.getArrivalCityId()));
                }
                if (filterDTO.getArrivalHotelId() != null) {
                    predicates.add(cb.equal(root.get("whereToHotel"), filterDTO.getArrivalHotelId()));
                }
                if (filterDTO.getDepartureDate() != null) {
                    predicates.add(cb.equal(root.get("departureDate"), filterDTO.getDepartureDate()));
                }
                if (filterDTO.getReturnDate() != null) {
                    predicates.add(cb.equal(root.get("returnDate"), filterDTO.getReturnDate()));
                }
                if (filterDTO.getType() != null) {
                    predicates.add(cb.equal(root.get("type"), filterDTO.getType()));
                }
                if (filterDTO.getHotelStars() != null) {
                    predicates.add(cb.equal(root.get("hotelStars"), filterDTO.getHotelStars()));
                }
                if (filterDTO.getDuration() != null) {
                    predicates.add(cb.equal(root.get("duration"), filterDTO.getDuration()));
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            };
        }
    }