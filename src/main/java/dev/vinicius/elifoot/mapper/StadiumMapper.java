package dev.vinicius.elifoot.mapper;

import dev.vinicius.elifoot.controller.request.StadiumRequest;
import dev.vinicius.elifoot.controller.response.StadiumResponse;
import dev.vinicius.elifoot.entity.Stadium;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StadiumMapper {

    StadiumResponse toResponse(Stadium stadium);
    Stadium toDomain(StadiumRequest stadiumRequest);
}
