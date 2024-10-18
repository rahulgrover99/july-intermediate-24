package parkinglot.strategies;

import parkinglot.models.*;

import java.util.Optional;

public class RandomSpotAssignmentStrategy implements  SlotAllocationStrategy{
    @Override
    public ParkingSpot getParkingSpot(Vehicle vehicle, ParkingLot parkingLot) {
        for (ParkingFloor parkingFloor: parkingLot.getParkingFloors()) {
            Optional<ParkingSpot> parkingSpotOptional =
                    parkingFloor.getParkingSpots().stream().
                            filter(slot -> slot.getParkingSpotStatus()
                                    .equals(ParkingSpotStatus.FREE) &&
                                    slot.getSupportedVehicleType()
                                            .contains(vehicle.getVehicleType()))
                            .findFirst();
            if (parkingSpotOptional.isPresent()) return parkingSpotOptional.get();
        }
        return null;
    }

}
