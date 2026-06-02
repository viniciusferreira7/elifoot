package dev.vinicius.elifoot.mapper;

import dev.vinicius.elifoot.controller.response.UserResponse;
import dev.vinicius.elifoot.entity.Scope;
import dev.vinicius.elifoot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "scopes", target = "scopes", qualifiedByName = "scopesToNames")
    UserResponse toResponse(User user);

    @Named("scopesToNames")
    default List<String> mapScopesToNames(List<Scope> scopes) {
        return scopes == null ? List.of() : scopes.stream().map(Scope::getName).toList();
    }
}
