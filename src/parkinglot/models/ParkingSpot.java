package parkinglot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ParkingSpot extends BaseModel {
    int spotNumber;
    ParkingFloor parkingFloor;
    ParkingSpotStatus parkingSpotStatus;
    List<VehicleType> supportedVehicleType;
    Vehicle vehicle;


}
