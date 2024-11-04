package com.example.bookmyshow.dtos;

import lombok.*;

import java.util.List;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookTicketRequestDto {
    private List<Long> showSeatIds;
}
