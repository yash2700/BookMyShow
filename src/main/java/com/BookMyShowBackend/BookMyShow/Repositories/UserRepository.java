package com.BookMyShowBackend.BookMyShow.Repositories;

import com.BookMyShowBackend.BookMyShow.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    List<UserEntity> findByName(String name);
}
