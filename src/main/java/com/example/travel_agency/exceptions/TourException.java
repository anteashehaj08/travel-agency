package com.example.travel_agency.exceptions;

public class TourException extends RuntimeException {
    public TourException(String message) {
        super(message);
    }
        public static TourException idMustBeNull() {
        return new TourException("Id must be null");
    }
    public static TourException idMustNotBeNull() {
        return new TourException("Id must not be null");
    }
    public static TourException idDoesNotExist(String name) {
        String message = String.format("%s with this Id does not exist", name);
        return new TourException(message);
    }
}
