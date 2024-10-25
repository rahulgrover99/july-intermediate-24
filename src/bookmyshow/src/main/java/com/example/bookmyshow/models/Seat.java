package com.example.bookmyshow.models;

import jakarta.persistence.*;

@Entity
public class Seat extends BaseModel {
    @Column(name = "seat_number")
    private int number;
    private char rowNum;
    private int colNum;
    @Enumerated
    private SeatType seatType;
    @ManyToOne
    private Screen screen;
}