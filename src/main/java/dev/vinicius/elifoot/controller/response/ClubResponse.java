package dev.vinicius.elifoot.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Summarized club data")
public class ClubResponse {

    @Schema(description = "Club UUID")
    private UUID id;

    @Schema(description = "Club name", example = "Flamengo")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    @Schema(description = "Foundation date", example = "1895/11/17")
    private LocalDate founded;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "URL of the club badge image")
    private String urlImage;
}
