package com.BookMyShowBackend.BookMyShow.Controllers;

import com.BookMyShowBackend.BookMyShow.Dtos.TheaterRequestDto;
import com.BookMyShowBackend.BookMyShow.Models.TheaterEntity;
import com.BookMyShowBackend.BookMyShow.Models.TheaterSeatEntity;
import com.BookMyShowBackend.BookMyShow.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    TheaterService theaterService;

    @PostMapping("/add")
    public String addTheater(@RequestBody TheaterRequestDto theaterRequestDto){
        return theaterService.createTheater(theaterRequestDto);
    }

    @GetMapping("/findbyid")
    public TheaterEntity findTheaterbyId(@RequestParam("id")Integer id){
        return theaterService.findTheaterById(id);
    }

    @GetMapping("/findall")
    public List<TheaterEntity> findAllTheaters(){
        return theaterService.findAllTheaters();
    }
}
