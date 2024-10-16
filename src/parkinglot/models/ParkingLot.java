package parkinglot.models;

import java.util.List;

public class ParkingLot extends BaseModel{
    List<ParkingFloor> parkingFloors;
    List<Gate> gates;
    List<VehicleType> vehicleTypes;
    String name;
}
