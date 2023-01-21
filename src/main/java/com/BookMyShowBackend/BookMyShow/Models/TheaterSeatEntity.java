package com.BookMyShowBackend.BookMyShow.Models;

import com.BookMyShowBackend.BookMyShow.Enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theaterseats")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TheaterSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public TheaterSeatEntity(String seatNo, SeatType seatType,int rate){
        this.seatNo=seatNo;
        this.seatType=seatType;
        this.rate=rate;
    }
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private int rate;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private TheaterEntity theater;

}
