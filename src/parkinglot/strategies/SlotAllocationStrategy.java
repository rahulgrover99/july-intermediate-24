package parkinglot.strategies;

import parkinglot.models.ParkingLot;
import parkinglot.models.ParkingSpot;
import parkinglot.models.Vehicle;

public interface SlotAllocationStrategy {

    ParkingSpot getParkingSpot(Vehicle vehicle, ParkingLot parkingLot);
}
