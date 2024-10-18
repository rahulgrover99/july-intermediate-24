package parkinglot.service;

public class SpotNotFoundException extends RuntimeException {
    SpotNotFoundException() {
        super("Parking lot out of spots.");
    }
}
