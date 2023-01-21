package com.BookMyShowBackend.BookMyShow.Converters;

import com.BookMyShowBackend.BookMyShow.Dtos.ShowRequestDto;
import com.BookMyShowBackend.BookMyShow.Models.ShowEntity;

public class ShowConverter {
    public static ShowEntity convertToEntity(ShowRequestDto showRequestDto){
        ShowEntity showEntity=ShowEntity.builder().showTime(showRequestDto.getShowTime()).showDate(showRequestDto.getShowDate()).multiplier(showRequestDto.getMultiplier()).build();
        return showEntity;

    }
}
