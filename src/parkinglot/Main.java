package parkinglot;

import parkinglot.controllers.TicketController;
import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;
import parkinglot.models.VehicleType;
import parkinglot.repository.ParkingLotRepository;
import parkinglot.service.TicketService;
import parkinglot.strategies.RandomSpotAssignmentStrategy;

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(VehicleType.SUV);
        vehicle.setRegistrationNumber("PB01AB1122");

        TicketController ticketController = new TicketController(new TicketService(new ParkingLotRepository(), new RandomSpotAssignmentStrategy()));

        Ticket ticket = ticketController.generateTicket(vehicle, 1L, 1L);

        System.out.println(ticket);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleType(VehicleType.SUV);
        vehicle2.setRegistrationNumber("PB01AB1123");

        Ticket ticket2 = ticketController.generateTicket(vehicle2, 1L, 1L);

        System.out.println(ticket2);

        Vehicle vehicle3 = new Vehicle();
        vehicle3.setVehicleType(VehicleType.SUV);
        vehicle3.setRegistrationNumber("PB01AB1124");

        Ticket ticket3 = ticketController.generateTicket(vehicle3, 1L, 1L);

        System.out.println(ticket3);

        Ticket ticket4 = ticketController.generateTicket(vehicle3, 1L, 1L);

        System.out.println(ticket4);

        Ticket ticket5 = ticketController.generateTicket(vehicle3, 1L, 1L);

        System.out.println(ticket5);


    }

}
