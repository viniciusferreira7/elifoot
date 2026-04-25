package dev.vinicius.elifoot.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Full player details including club information")
public class PlayerDetailsResponse {

    @Schema(description = "Player ID")
    private Long id;

    @Schema(description = "Player full name", example = "Gabigol")
    private String name;

    @Schema(description = "Player position label", example = "Forward")
    private String position;

    @Schema(description = "Shirt number", example = "10")
    private int shirtNumber;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "URL of the player photo")
    private String urlImg;

    @Schema(description = "Club the player belongs to")
    private ClubBasicResponse club;
}
