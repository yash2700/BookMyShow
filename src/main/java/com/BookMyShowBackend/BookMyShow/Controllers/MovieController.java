package com.BookMyShowBackend.BookMyShow.Controllers;

import com.BookMyShowBackend.BookMyShow.Dtos.MovieRequestDto;
import com.BookMyShowBackend.BookMyShow.Models.MovieEntity;
import com.BookMyShowBackend.BookMyShow.Models.UserEntity;
import com.BookMyShowBackend.BookMyShow.Service.MovieService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;
    @PostMapping("/add")
    public String addMovie(@RequestBody MovieRequestDto movieRequestDto){
        try {
          return   movieService.createMovie(movieRequestDto);
        }catch (Exception e)
        {
            return e.toString();
        }
    }

    @GetMapping("/findbyname")
    public MovieEntity findMoviesByName(@RequestParam("name")String name){
        return movieService.findMoviesByName(name);
    }
}
