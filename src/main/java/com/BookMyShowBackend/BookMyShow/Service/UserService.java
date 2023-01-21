package com.BookMyShowBackend.BookMyShow.Service;

import com.BookMyShowBackend.BookMyShow.Converters.UserConverter;
import com.BookMyShowBackend.BookMyShow.Dtos.UserRequestDto;
import com.BookMyShowBackend.BookMyShow.Models.UserEntity;
import com.BookMyShowBackend.BookMyShow.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;



    public String createUser(UserRequestDto userRequestDto) throws Exception{
        UserEntity user=UserConverter.convertToEntity(userRequestDto);
        try {
            userRepository.save(user);
        }
        catch (Exception e) {return "user couldn't be added";}
        return "user added succesfully";
    }

    public List<UserEntity> findUserByName(String name){
        return userRepository.findByName(name);
    }

}
