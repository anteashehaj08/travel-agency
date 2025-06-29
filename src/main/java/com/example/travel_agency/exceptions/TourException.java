package com.example.travel_agency.exceptions;

public class TourException extends RuntimeException {
    public TourException(String message) {
        super(message);
    }
        public static TourException idMustBeNull() {
        String message = String.format("Tour id must be null");
        return new TourException(message);
    }
    public static TourException idMustNotBeNull() {
        String message = String.format("Tour id must not be null");
        return new TourException(message);
    }
    public static TourException idDoesNotExist() {
        String message = String.format("Tour id does not exist");
        return new TourException(message);
    }
}
