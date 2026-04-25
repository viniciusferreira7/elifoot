package dev.vinicius.elifoot.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Basic club identification data")
public class ClubBasicResponse {

    @Schema(description = "Club ID")
    private Long id;

    @Schema(description = "Club name", example = "Flamengo")
    private String name;
}
