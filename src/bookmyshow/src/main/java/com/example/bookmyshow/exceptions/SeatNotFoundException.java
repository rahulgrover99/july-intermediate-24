package com.example.bookmyshow.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SeatNotFoundException extends RuntimeException{

    public SeatNotFoundException() {
        super("Seat not found in storage.");
    }
}
