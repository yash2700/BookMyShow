package com.BookMyShowBackend.BookMyShow.Service;

import com.BookMyShowBackend.BookMyShow.Converters.MovieConverter;
import com.BookMyShowBackend.BookMyShow.Dtos.MovieRequestDto;
import com.BookMyShowBackend.BookMyShow.Models.MovieEntity;
import com.BookMyShowBackend.BookMyShow.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


    @Autowired
    MovieRepository movieRepository;

    public String createMovie(MovieRequestDto movieRequestDto) throws Exception{
        MovieEntity movieEntity=MovieConverter.convertToEntity(movieRequestDto);
        try{
            movieRepository.save(movieEntity);
        }
        catch (Exception e){
            return "not successful";
        }
        return "Successfully added";
    }
    public MovieEntity findMoviesByName(String name){
        return movieRepository.findByMovieName(name);
    }
}
