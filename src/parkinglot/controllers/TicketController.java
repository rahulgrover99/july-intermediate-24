package parkinglot.controllers;

import parkinglot.models.*;
import parkinglot.service.TicketService;
import parkinglot.strategies.FeeCalculationStrategy;
import parkinglot.strategies.RandomSpotAssignmentStrategy;
import parkinglot.strategies.SlotAllocationStrategy;

import java.time.Instant;
import java.util.Date;

public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public Ticket generateTicket(Vehicle vehicle,
                                 Long gateId, Long parkingLotId) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle is null");
        }

        return ticketService.generateTicket(vehicle, gateId, parkingLotId);
    }

    public Ticket cancelTicket() {
        return null;
    }


}
