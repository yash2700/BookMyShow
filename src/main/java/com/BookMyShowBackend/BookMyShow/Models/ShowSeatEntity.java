package com.BookMyShowBackend.BookMyShow.Models;

import com.BookMyShowBackend.BookMyShow.Enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "showseats")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private boolean booked;

    @CreationTimestamp
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private ShowEntity show;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private TicketEntity ticket;


}
