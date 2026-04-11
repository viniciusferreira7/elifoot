package dev.vinicius.elifoot.mapper;

import dev.vinicius.elifoot.controller.response.StadiumResponse;
import dev.vinicius.elifoot.entity.Stadium;

public class StadiumMapper {
//    public static Stadium toEntity(CreateStadiumRequest request);

    public static StadiumResponse toResponse(Stadium stadium){
        return StadiumResponse.builder()
                .id(stadium.getId())
                .name(stadium.getName())
                .city(stadium.getCity())
                .capacity(stadium.getCapacity())
                .urlImg(stadium.getUrlImg())
                .build();
    }
}
