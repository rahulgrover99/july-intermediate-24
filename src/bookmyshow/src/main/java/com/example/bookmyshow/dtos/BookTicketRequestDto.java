package com.example.bookmyshow.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Builder
@Data
@ToString
public class BookTicketRequestDto {
    private List<Long> showSeatIds;
}
