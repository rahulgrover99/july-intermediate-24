package parkinglot.controllers;

import parkinglot.models.*;
import parkinglot.strategies.FeeCalculationStrategy;
import parkinglot.strategies.SlotAllocationStrategy;

import java.time.Instant;
import java.util.Date;

public class TicketController {

    private final SlotAllocationStrategy slotAllocationStrategy;

    public TicketController(SlotAllocationStrategy slotAllocationStrategy) {
        this.slotAllocationStrategy = slotAllocationStrategy;
    }

    public Ticket generateTicket(Vehicle vehicle,
                                 Gate gate) {

        // 1. Spot Allocation Strategy would get us the slot
        // 2. Block the slot. Update available slots.
        // 3. Create the ticket object.
        ParkingSpot spot = slotAllocationStrategy.getParkingSpot(vehicle, gate.getParkingLot());

        spot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        spot.setVehicle(vehicle);

        Ticket ticket = Ticket.builder()
                .entryTime(Date.from(Instant.now()))
                .parkingSpot(spot)
                .operator(gate.getOperator())
                .vehicle(vehicle)
                .build();

        ticket.setId(1L);

        return ticket;
    }


}
