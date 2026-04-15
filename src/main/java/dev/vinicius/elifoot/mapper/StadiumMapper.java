package dev.vinicius.elifoot.mapper;

import dev.vinicius.elifoot.controller.request.StadiumRequest;
import dev.vinicius.elifoot.controller.response.StadiumResponse;
import dev.vinicius.elifoot.entity.Stadium;

public class StadiumMapper {

    public static StadiumResponse toResponse(Stadium stadium){
        return StadiumResponse.builder()
                .id(stadium.getId())
                .name(stadium.getName())
                .city(stadium.getCity())
                .capacity(stadium.getCapacity())
                .urlImg(stadium.getUrlImg())
                .build();
    }

    public static Stadium toDomain(StadiumRequest stadiumRequest){
        return Stadium.builder()
                .name(stadiumRequest.getName())
                .city(stadiumRequest.getCity())
                .capacity(stadiumRequest.getCapacity())
                .urlImg(stadiumRequest.getUrlImage())
                .build();
               
    }
}
