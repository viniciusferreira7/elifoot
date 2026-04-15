package dev.vinicius.elifoot.controller.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StadiumRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String city;
    private Integer capacity;
    private String urlImage;
}
