package dev.vinicius.elifoot.mapper;


import dev.vinicius.elifoot.controller.request.PlayerRequest;
import dev.vinicius.elifoot.controller.response.PlayerDetailsResponse;
import dev.vinicius.elifoot.controller.response.PlayerResponse;
import dev.vinicius.elifoot.entity.Player;
import dev.vinicius.elifoot.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(source = "position", target = "position", qualifiedByName = "enumToString")
    PlayerResponse toResponse(Player player);

    @Mapping(source = "position", target = "position", qualifiedByName = "enumToString")
    PlayerDetailsResponse toDetailsResponse(Player player);

    @Mapping(target = "club.id", source = "clubId")
    Player toEntity(PlayerRequest request);

    @Named("enumToString")
    default String mapPositionToString(Position position) {
        return position != null ? position.getLabel() : null;
    }
}