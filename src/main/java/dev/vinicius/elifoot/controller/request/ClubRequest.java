package dev.vinicius.elifoot.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Payload to register a new club")
public class ClubRequest {

    @NotBlank
    @Schema(description = "Club name", example = "Flamengo")
    private String name;

    @NotNull
    @Schema(description = "Foundation date (ISO-8601)", example = "1895-11-17")
    private LocalDate founded;

    @Schema(description = "URL of the club badge image")
    private String urlImg;

    @Schema(description = "UUID of the stadium the club plays in")
    private UUID stadiumId;
}
