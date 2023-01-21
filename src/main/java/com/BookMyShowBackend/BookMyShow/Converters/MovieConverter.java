package com.BookMyShowBackend.BookMyShow.Converters;

import com.BookMyShowBackend.BookMyShow.Dtos.MovieRequestDto;
import com.BookMyShowBackend.BookMyShow.Models.MovieEntity;

public class MovieConverter {
    public static MovieEntity convertToEntity(MovieRequestDto movieRequestDto){
        MovieEntity movieEntity=MovieEntity.builder().movieName(movieRequestDto.getName()).duration(movieRequestDto.getDureation()).releaseDate(movieRequestDto.getReleaseDate()).build();
        return movieEntity;
    }
}
