package com.BookMyShowBackend.BookMyShow.Repositories;

import com.BookMyShowBackend.BookMyShow.Models.TheaterSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterSeatRepository extends JpaRepository<TheaterSeatEntity,Integer> {
}
