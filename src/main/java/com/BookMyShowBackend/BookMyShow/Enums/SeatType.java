package com.BookMyShowBackend.BookMyShow.Enums;

import jakarta.persistence.Table;

@Table(name = "seat_type")
public enum SeatType {
    CLASSIC,
    VIP
}
