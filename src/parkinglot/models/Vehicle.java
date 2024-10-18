package parkinglot.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Vehicle extends BaseModel{
    String registrationNumber;
    VehicleType vehicleType;
}
