package parkinglot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gate extends BaseModel {
    int gateNumber;
    Operator operator;
    GateType gateType;
    ParkingLot parkingLot;
}
