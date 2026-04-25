package dev.vinicius.elifoot.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Payload to register a new stadium")
public class StadiumRequest {

    @NotBlank
    @Schema(description = "Stadium name", example = "Maracanã")
    private String name;

    @NotBlank
    @Schema(description = "City where the stadium is located", example = "Rio de Janeiro")
    private String city;

    @Schema(description = "Maximum seating capacity", example = "78838")
    private Integer capacity;

    @Schema(description = "URL of the stadium image")
    private String urlImage;
}
