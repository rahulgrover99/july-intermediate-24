package parkinglot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingFloor extends BaseModel{
    private int floorNumber;
    private List<ParkingSpot> parkingSpots;

}
