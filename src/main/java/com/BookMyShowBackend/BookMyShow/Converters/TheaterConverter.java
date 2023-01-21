package com.BookMyShowBackend.BookMyShow.Converters;

import com.BookMyShowBackend.BookMyShow.Dtos.TheaterRequestDto;
import com.BookMyShowBackend.BookMyShow.Models.TheaterEntity;

public class TheaterConverter {

    public static TheaterEntity convertToEntity(TheaterRequestDto theaterRequestDto){
        TheaterEntity theaterEntity=TheaterEntity.builder().name(theaterRequestDto.getName()).city(theaterRequestDto.getCity()).address(theaterRequestDto.getAddress()).build();
        return  theaterEntity;
    }
}
