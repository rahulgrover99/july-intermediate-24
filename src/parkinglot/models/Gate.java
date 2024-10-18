package parkinglot.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Gate extends BaseModel {
    int gateNumber;
    Operator operator;
    GateType gateType;

    public Gate(int gateNumber, GateType gateType) {
        this.gateNumber = gateNumber;
        this.gateType = gateType;
    }
}
