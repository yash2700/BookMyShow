package com.BookMyShowBackend.BookMyShow.Service;

import com.BookMyShowBackend.BookMyShow.Converters.ShowConverter;
import com.BookMyShowBackend.BookMyShow.Dtos.ShowRequestDto;
import com.BookMyShowBackend.BookMyShow.Models.*;
import com.BookMyShowBackend.BookMyShow.Repositories.MovieRepository;
import com.BookMyShowBackend.BookMyShow.Repositories.ShowRepository;
import com.BookMyShowBackend.BookMyShow.Repositories.ShowSeatRepository;
import com.BookMyShowBackend.BookMyShow.Repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;


    public String createShow(ShowRequestDto showRequestDto){
        ShowEntity showEntity= ShowConverter.convertToEntity(showRequestDto);

        MovieEntity movieEntity=movieRepository.findByMovieName(showRequestDto.getMovieName());

        int id=showRequestDto.getTid();
        TheaterEntity theaterEntity=theaterRepository.findById(id).get();

        System.out.println(showRequestDto.getTid());
        showEntity.setTheater(theaterEntity);

        showEntity.setMovie(movieEntity);

        movieEntity.getListOfShows().add(showEntity);
        theaterEntity.getListOfShows().add(showEntity);

        List<ShowSeatEntity> showSeatEntityList=createShowSeats(theaterEntity.getListOfSeats());

        showEntity.setListOfSeats(showSeatEntityList);

        for(ShowSeatEntity showSeatEntity:showSeatEntityList){
            showSeatEntity.setShow(showEntity);
        }
        //showRepository.save(showEntity);
        movieRepository.save(movieEntity);
        theaterRepository.save(theaterEntity);

        return "successfully added";
    }

    public List<ShowSeatEntity> createShowSeats(List<TheaterSeatEntity> listOfSeats){
        List<ShowSeatEntity> showSeatEntityList=new ArrayList<>();
        for(TheaterSeatEntity theaterSeatEntity:listOfSeats){
            ShowSeatEntity showSeatEntity=ShowSeatEntity.builder().seatNo(theaterSeatEntity.getSeatNo()).seatType(theaterSeatEntity.getSeatType()).build();
            showSeatEntityList.add(showSeatEntity);
        }
        showSeatRepository.saveAll(showSeatEntityList);
        return showSeatEntityList;
    }
}
