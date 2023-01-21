package com.BookMyShowBackend.BookMyShow.Repositories;

import com.BookMyShowBackend.BookMyShow.Models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {
    MovieEntity findByMovieName(String name);
}
