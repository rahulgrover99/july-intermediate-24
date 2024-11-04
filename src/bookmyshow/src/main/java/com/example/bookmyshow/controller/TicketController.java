package com.example.bookmyshow.controller;

import com.example.bookmyshow.dtos.BookTicketRequestDto;
import com.example.bookmyshow.dtos.BookTicketResponseDto;
import com.example.bookmyshow.models.BaseModel;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket/")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(path = "book")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody BookTicketResponseDto bookTicket(
            @RequestBody BookTicketRequestDto request
            ) {

        System.out.println("Request for booking received.");
        System.out.println(request);

        Booking booking = ticketService.book(request.getShowSeatIds());

        return BookTicketResponseDto.builder()
                .bookingReference(booking.getId())
                .amount(booking.getAmount())
                .seatIds(booking.getShowSeatList().stream().map(BaseModel::getId).toList())
                .theatreName(booking.getShowSeatList().get(0).getShow().getScreen().getTheatre().getName())
                .build();

    }

    @GetMapping(path = "/get")
    @ResponseStatus(HttpStatus.OK)
    public String getTicket() {
        System.out.println("Request hits the server - 2");
        return "Get the ticket for you, world!";
    }
}