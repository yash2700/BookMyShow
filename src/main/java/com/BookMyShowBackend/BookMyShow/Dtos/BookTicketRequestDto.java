package com.BookMyShowBackend.BookMyShow.Dtos;

import lombok.Data;

import java.util.List;

@Data
public class BookTicketRequestDto {
    private int userId;

    private  int showId;

    List<String> requestedSeats;
}
