package parkinglot.repository;

import parkinglot.models.*;

import java.util.List;

public class ParkingLotRepository {

    private static ParkingLot INSTANCE = getParkingLot();

    public static ParkingLot getParkingLot() {
        ParkingFloor floor0 = ParkingFloor.builder()
                .floorNumber(1)
                .parkingSpots(List.of(new ParkingSpot(1), new ParkingSpot(2) ))
                .build();

        ParkingFloor floor1 = ParkingFloor.builder()
                .floorNumber(2)
                .parkingSpots(List.of(new ParkingSpot(3), new ParkingSpot(4) ))
                .build();

        Gate entryGate = new Gate(1, GateType.ENTRY);
        Gate exitGate = new Gate(2, GateType.EXIT);

        return ParkingLot.builder()
                .name("Elante Mall Parking")
                .gates(List.of(entryGate, exitGate))
                .parkingFloors(List.of(floor1, floor0))
                .vehicleTypes(List.of(VehicleType.SUV, VehicleType.SEDAN, VehicleType.HATCHBACK))
                .build();
    }

    public ParkingLot findById(long id) {
        return INSTANCE;

    }
}
