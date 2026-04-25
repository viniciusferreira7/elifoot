package dev.vinicius.elifoot.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@Schema(description = "Stadium data")
public class StadiumResponse {

    @Schema(description = "Stadium UUID")
    private UUID id;

    @Schema(description = "Stadium name", example = "Maracanã")
    private String name;

    @Schema(description = "City where the stadium is located", example = "Rio de Janeiro")
    private String city;

    @Schema(description = "Maximum seating capacity", example = "78838")
    private Integer capacity;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "URL of the stadium image")
    private String urlImg;
}
