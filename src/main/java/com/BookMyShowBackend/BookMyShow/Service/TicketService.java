package com.BookMyShowBackend.BookMyShow.Service;

import com.BookMyShowBackend.BookMyShow.Dtos.BookTicketRequestDto;
import com.BookMyShowBackend.BookMyShow.Models.ShowEntity;
import com.BookMyShowBackend.BookMyShow.Models.ShowSeatEntity;
import com.BookMyShowBackend.BookMyShow.Models.TicketEntity;
import com.BookMyShowBackend.BookMyShow.Models.UserEntity;
import com.BookMyShowBackend.BookMyShow.Repositories.ShowRepository;
import com.BookMyShowBackend.BookMyShow.Repositories.TicketRepository;
import com.BookMyShowBackend.BookMyShow.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    public String bookTicket(BookTicketRequestDto bookTicketRequestDto) throws Exception {
        List<String> requestedSeats=bookTicketRequestDto.getRequestedSeats();
        ShowEntity showEntity=showRepository.findById(bookTicketRequestDto.getShowId()).get();
        UserEntity userEntity=userRepository.findById(bookTicketRequestDto.getUserId()).get();

        List<ShowSeatEntity> showSeatEntityList=showEntity.getListOfSeats();

        List<ShowSeatEntity> bookedSeats=new ArrayList<>();

        for(ShowSeatEntity seat:showSeatEntityList){
            String seatNo=seat.getSeatNo();
            if(seat.isBooked()==false&&requestedSeats.contains(seatNo)) {
                bookedSeats.add(seat);
            }
        }

        if(bookedSeats.size()!=requestedSeats.size()){
            throw  new Exception("not all seats are available");
        }

        double totalAmount=0;
        int rate=0;
        double multiplier=showEntity.getMultiplier();
        TicketEntity ticket=new TicketEntity();
        String allotedSeats="";
        for(ShowSeatEntity booked:bookedSeats){
            booked.setBooked(true);
            booked.setBookedAt(new Date());
            booked.setTicket(ticket);
            booked.setShow(showEntity);

            allotedSeats+=booked.getSeatNo()+",";
            if(booked.getSeatNo().charAt(0)=='1'){
                rate=100;
            }else {
                rate=200;
            }
            totalAmount+=rate;
        }

        totalAmount*=multiplier;

        ticket.setBooked_at(new Date());

        ticket.setAmount((int)totalAmount);

        ticket.setShow(showEntity);

        ticket.setUser(userEntity);

        ticket.setBookedSeats(bookedSeats);

        ticket.setAllotedSeats(allotedSeats);

        ticketRepository.save(ticket);

        return "successfully added";

    }
}
