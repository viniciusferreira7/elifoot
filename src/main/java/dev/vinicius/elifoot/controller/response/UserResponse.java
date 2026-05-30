package dev.vinicius.elifoot.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "User data")
public class UserResponse {

    @Schema(description = "User UUID")
    private UUID id;

    @Schema(description = "User full name", example = "John Doe")
    private String name;

    @Schema(description = "User e-mail address", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Whether the user account is active")
    private Boolean active;

    @Schema(description = "Scopes assigned to the user")
    private List<String> scopes;
}
