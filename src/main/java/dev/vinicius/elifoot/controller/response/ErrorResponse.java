package dev.vinicius.elifoot.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.Map;

@Builder
@Getter
@Schema(description = "Standard error response")
public class ErrorResponse {

    @Schema(description = "HTTP status code", example = "404")
    private int status;

    @Schema(description = "Short error title", example = "Resource not found")
    private String error;

    @Schema(description = "Human-readable error detail", example = "Stadium not found")
    private String message;

    @Schema(description = "Moment the error occurred")
    private Instant timestamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "Field-level validation messages, keyed by field name")
    private Map<String, String> errors;
}
