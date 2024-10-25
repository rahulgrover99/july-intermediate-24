package com.example.bookmyshow.service;

import com.example.bookmyshow.exceptions.SeatNotFoundException;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.models.ShowSeatStatus;
import com.example.bookmyshow.repository.ShowSeatRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final ShowSeatRepository showSeatRepository;

    public TicketService(ShowSeatRepository showSeatRepository) {
        this.showSeatRepository = showSeatRepository;
    }


    public Booking book(List<Long> showSeatIds) {
        // 1. Query the DB for the given show seat IDs.

        List<ShowSeat> showSeatList = showSeatRepository.findAllById(showSeatIds);

        if (showSeatIds.size() != showSeatList.size()) {
            throw new SeatNotFoundException();
        }

        double amount = 0;
        for (ShowSeat showSeat: showSeatList) {
            if (showSeat.getShowSeatStatus() != ShowSeatStatus.AVAILABLE) {
                throw new IllegalArgumentException("Seats no longer available.");
            }
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            amount += showSeat.getPrice();
        }


        showSeatRepository.saveAll(showSeatList);

        Booking booking = Booking.builder()
                .amount(amount)
                .showSeatList(showSeatList)
                .show(showSeatList.get(0).getShow())
                .build();

//        bookingRepository.save(booking);

        return booking;
    }
}
