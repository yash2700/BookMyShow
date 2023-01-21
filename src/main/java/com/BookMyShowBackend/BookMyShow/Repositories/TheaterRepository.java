package com.BookMyShowBackend.BookMyShow.Repositories;

import com.BookMyShowBackend.BookMyShow.Models.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {
}
