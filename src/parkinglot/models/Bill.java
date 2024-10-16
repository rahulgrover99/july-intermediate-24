package parkinglot.models;

import java.util.Date;

public class Bill extends BaseModel{
    private Gate gate;
    private Double amount;
    private Operator operator;
    private Ticket ticket;
    private Date exitTime;
//    private FeeCalculationStrategy feeCalculationStrategy;
}
