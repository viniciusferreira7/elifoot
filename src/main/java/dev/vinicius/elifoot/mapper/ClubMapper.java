package dev.vinicius.elifoot.mapper;

import dev.vinicius.elifoot.controller.request.ClubRequest;
import dev.vinicius.elifoot.controller.response.ClubDetailsResponse;
import dev.vinicius.elifoot.controller.response.ClubResponse;
import dev.vinicius.elifoot.entity.Club;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClubMapper {
    ClubResponse toResponse(Club club);
    ClubDetailsResponse toDetailsResponse(Club club);

    Club toDomain(ClubRequest clubRequest);
}
