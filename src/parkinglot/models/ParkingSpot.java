package parkinglot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ParkingSpot extends BaseModel {
    int spotNumber;
    ParkingSpotStatus parkingSpotStatus;
    List<VehicleType> supportedVehicleType;
    Vehicle vehicle;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.parkingSpotStatus = ParkingSpotStatus.FREE;
        this.supportedVehicleType = List.of(VehicleType.SUV, VehicleType.SEDAN);
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotNumber=" + spotNumber +
                ", parkingSpotStatus=" + parkingSpotStatus +
                ", vehicle=" + vehicle +
                '}';
    }
}
