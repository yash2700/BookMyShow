package com.BookMyShowBackend.BookMyShow.Dtos;

import lombok.Data;

import java.util.Date;
@Data
public class MovieRequestDto {
    private String  name;
    private int dureation;

    private Date releaseDate;
}
