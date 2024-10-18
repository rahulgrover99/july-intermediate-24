package parkinglot.models;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class ParkingLot extends BaseModel{
    List<ParkingFloor> parkingFloors;
    List<Gate> gates;
    List<VehicleType> vehicleTypes;
    String name;
}
