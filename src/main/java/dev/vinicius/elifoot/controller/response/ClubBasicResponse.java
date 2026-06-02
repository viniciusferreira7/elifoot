package dev.vinicius.elifoot.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Schema(description = "Basic club identification data")
public class ClubBasicResponse {

    @Schema(description = "Club UUID")
    private UUID id;

    @Schema(description = "Club name", example = "Flamengo")
    private String name;
}
