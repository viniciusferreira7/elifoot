package dev.vinicius.elifoot.controller.request;

import dev.vinicius.elifoot.entity.Position;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Schema(description = "Payload to register a new player")
public class PlayerRequest {

    @NotBlank
    @Schema(description = "Player full name", example = "Gabigol")
    private String name;

    @NotNull
    @Schema(description = "Player position on the field", example = "FORWARD")
    private Position position;

    @NotNull
    @Schema(description = "Shirt number", example = "10")
    private int shirtNumber;

    @Schema(description = "URL of the player photo")
    private String urlImg;

    @NotNull
    @Schema(description = "ID of the club the player belongs to", example = "1")
    private Long clubId;
}
