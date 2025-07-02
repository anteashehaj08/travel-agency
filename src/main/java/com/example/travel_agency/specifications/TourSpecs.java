package com.example.travel_agency.specifications;

import com.example.travel_agency.entities.Tour;
import com.example.travel_agency.statics.ContinentEnum;
import org.springframework.data.jpa.domain.Specification;

public class TourSpecs {
    public class TourOfferSpecs {

        public static Specification<Tour> hasContinent(ContinentEnum continent) {
            return (root, query, cb) ->
                    cb.equal(root.get("continent"), continent);
        }

        public static Specification<Tour> hasCountry(Long countryId) {
            return (root, query, cb) ->
                    cb.equal(root.get("country").get("id"), countryId);
        }

        public static Specification<Tour> hasCity(Long cityId) {
            return (root, query, cb) ->
                    cb.equal(root.get("city").get("id"), cityId);
        }

        public static Specification<Tour> hasHotel(Long hotelId) {
            return (root, query, cb) ->
                    cb.equal(root.get("hotel").get("id"), hotelId);
        }
    }
}
