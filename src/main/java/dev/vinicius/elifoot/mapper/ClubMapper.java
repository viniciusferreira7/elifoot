package dev.vinicius.elifoot.mapper;

import dev.vinicius.elifoot.controller.request.ClubRequest;
import dev.vinicius.elifoot.controller.response.ClubDetailsResponse;
import dev.vinicius.elifoot.controller.response.ClubResponse;
import dev.vinicius.elifoot.entity.Club;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClubMapper {
    ClubResponse toResponse(Club club);
    ClubDetailsResponse toDetailsResponse(Club club);

    @Mapping(target = "stadium.id", source = "stadium_id")
    Club toDomain(ClubRequest clubRequest);
}
