package dev.vinicius.elifoot.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema(description = "Summarized player data")
public class PlayerResponse {

    @Schema(description = "Player UUID")
    private UUID id;

    @Schema(description = "Player full name", example = "Gabigol")
    private String name;

    @Schema(description = "Player position label", example = "Forward")
    private String position;

    @Schema(description = "Shirt number", example = "10")
    private int shirtNumber;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "URL of the player photo")
    private String urlImg;
}
