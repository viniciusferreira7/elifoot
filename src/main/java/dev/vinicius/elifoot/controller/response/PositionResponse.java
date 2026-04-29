package dev.vinicius.elifoot.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Player position with its display label")
public class PositionResponse {

    @Schema(description = "Position enum value", example = "FORWARD")
    private String value;

    @Schema(description = "Human-readable position label", example = "Forward")
    private String label;
}
