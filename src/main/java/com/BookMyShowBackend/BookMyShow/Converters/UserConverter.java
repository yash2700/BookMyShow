package com.BookMyShowBackend.BookMyShow.Converters;

import com.BookMyShowBackend.BookMyShow.Dtos.UserRequestDto;
import com.BookMyShowBackend.BookMyShow.Models.UserEntity;

public class UserConverter {

    public static UserEntity convertToEntity(UserRequestDto userRequestDto){
        UserEntity user=UserEntity.builder().name(userRequestDto.getName()).mobile(userRequestDto.getMobile()).build();
        return user;
    }
}
