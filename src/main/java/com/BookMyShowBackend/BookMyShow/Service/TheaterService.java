package com.BookMyShowBackend.BookMyShow.Service;

import com.BookMyShowBackend.BookMyShow.Converters.TheaterConverter;
import com.BookMyShowBackend.BookMyShow.Dtos.TheaterRequestDto;
import com.BookMyShowBackend.BookMyShow.Enums.SeatType;
import com.BookMyShowBackend.BookMyShow.Models.TheaterEntity;
import com.BookMyShowBackend.BookMyShow.Models.TheaterSeatEntity;
import com.BookMyShowBackend.BookMyShow.Repositories.TheaterRepository;
import com.BookMyShowBackend.BookMyShow.Repositories.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    TheaterRepository theaterRepository;

   @Autowired
    TheaterSeatRepository theaterSeatEntityRepository;


    public String createTheater(TheaterRequestDto theaterRequestDto){
        TheaterEntity theaterEntity= TheaterConverter.convertToEntity(theaterRequestDto);
        List<TheaterSeatEntity> theaterSeatEntityList=createTheaterSeatSeats();

        theaterEntity.setListOfSeats(theaterSeatEntityList);

        for(TheaterSeatEntity theaterSeatEntity:theaterSeatEntityList){
            theaterSeatEntity.setTheater(theaterEntity);
        }

        theaterRepository.save(theaterEntity);

        return "Successfully added";
    }

    private List<TheaterSeatEntity> createTheaterSeatSeats(){
        List<TheaterSeatEntity> seats=new ArrayList<>();
        for(int i=0;i<5;i++){
            char ch=(char) ('A'+i);
            String seatNo="1"+ch;
            TheaterSeatEntity theaterSeatEntity=new TheaterSeatEntity(seatNo,SeatType.CLASSIC,100);
            seats.add(theaterSeatEntity);
            char ch1=(char) ('A'+i);
            String seatNo1="2"+ch1;
            TheaterSeatEntity theaterSeatEntity1=new TheaterSeatEntity(seatNo,SeatType.VIP,200);
            seats.add(theaterSeatEntity1);
        }
        theaterSeatEntityRepository.saveAll(seats);

        return seats;


    }

    public TheaterEntity findTheaterById(Integer id){
        return theaterRepository.findById(id).get();
    }

    public List<TheaterEntity> findAllTheaters(){
        return theaterRepository.findAll();
    }
}
