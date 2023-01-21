package com.BookMyShowBackend.BookMyShow.Dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
public class ShowRequestDto {
    private LocalDate showDate;

    private LocalTime showTime;

    private String movieName;

     int tid;

    private double multiplier;
}
