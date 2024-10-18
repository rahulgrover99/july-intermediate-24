package parkinglot.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ParkingFloor extends BaseModel{
    private int floorNumber;
    private List<ParkingSpot> parkingSpots;

}
