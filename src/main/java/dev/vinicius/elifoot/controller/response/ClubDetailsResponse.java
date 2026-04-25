package dev.vinicius.elifoot.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Schema(description = "Full club details including stadium information")
public class ClubDetailsResponse {

    @Schema(description = "Club UUID")
    private UUID id;

    @Schema(description = "Club name", example = "Flamengo")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Schema(description = "Foundation date", example = "17/11/1895")
    private LocalDate founded;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "URL of the club badge image")
    private String urlImg;

    @Schema(description = "Stadium the club plays in")
    private StadiumResponse stadium;
}
