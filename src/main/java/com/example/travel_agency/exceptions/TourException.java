package com.example.travel_agency.exceptions;

public class TourException extends RuntimeException {
    public TourException(String message) {
        super(message);
    }
        public static TourException idMustBeNull(String name) {
        String message = String.format("%s Id must be null", name);
        return new TourException(message);
    }
    public static TourException idMustNotBeNull(String name) {
        String message = String.format("Tour Id must not be null", name);
        return new TourException(message);
    }
    public static TourException idDoesNotExist(String name) {
        String message = String.format("%s with this Id does not exist", name);
        return new TourException(message);
    }
}
