package parkinglot.models;

import lombok.Builder;
import lombok.experimental.Accessors;

import java.util.Date;

@Builder
@Accessors(prefix = "set")
public class Ticket extends BaseModel{
    private Vehicle vehicle;
    private Operator operator;
    private Gate generatedAt;
    private ParkingSpot parkingSpot;
    private Date entryTime;

    @Override
    public String toString() {
        return "Ticket{" +
                "vehicle=" + vehicle +
                ", generatedAt=" + generatedAt +
                ", parkingSpot=" + parkingSpot +
                ", entryTime=" + entryTime +
                '}';
    }
}
