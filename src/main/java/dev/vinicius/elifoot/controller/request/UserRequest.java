package dev.vinicius.elifoot.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Payload to register a new user")
public class UserRequest {

    @NotBlank
    @Schema(description = "User full name", example = "John Doe")
    private String name;

    @NotBlank
    @Email
    @Schema(description = "User e-mail address", example = "john.doe@example.com")
    private String email;

    @NotBlank
    @Schema(description = "User password")
    private String password;

    @Schema(description = "List of scope IDs to assign to the user")
    private List<String> scopeIds;
}
