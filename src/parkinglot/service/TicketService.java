package parkinglot.service;

import parkinglot.models.*;
import parkinglot.repository.ParkingLotRepository;
import parkinglot.strategies.SlotAllocationStrategy;

import java.time.Instant;
import java.util.Date;

public class TicketService {

    ParkingLotRepository parkingLotRepository;
    SlotAllocationStrategy spotAllocationStrategy;

    public TicketService(ParkingLotRepository parkingLotRepository, SlotAllocationStrategy spotAllocationStrategy) {
        this.parkingLotRepository = parkingLotRepository;
        this.spotAllocationStrategy = spotAllocationStrategy;
    }

    public Ticket generateTicket(Vehicle vehicle,
                                 Long gateId, Long parkingLotId) {

        // 1. Spot Allocation Strategy would get us the slot
        // 2. Block the slot. Update available slots.
        // 3. Create the ticket object.

        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId);


        ParkingSpot spot = spotAllocationStrategy.getParkingSpot(vehicle, parkingLot);

        if (spot == null) {
            throw new SpotNotFoundException();
        }

        spot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        spot.setVehicle(vehicle);

        Gate entryGate  = parkingLot.getGates().stream().
                filter(gate -> gate.getGateNumber() == gateId)
                .findFirst().get();

        Ticket ticket = Ticket.builder()
                .entryTime(Date.from(Instant.now()))
                .parkingSpot(spot)
                .operator(entryGate.getOperator())
                .vehicle(vehicle)
                .generatedAt(entryGate)
                .build();

        ticket.setId(1L);

        return ticket;
    }


}
