package dev.vinicius.elifoot.controller;

import dev.vinicius.elifoot.controller.request.StadiumRequest;
import dev.vinicius.elifoot.controller.response.StadiumResponse;
import dev.vinicius.elifoot.service.CreateStadiumService;
import dev.vinicius.elifoot.service.FindStadiumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stadiums")
@Tag(name = "Stadiums", description = "Stadium management API")
public class StadiumController {

    private final FindStadiumService findStadiumService;
    private final CreateStadiumService createStadiumService;

    public StadiumController(
            FindStadiumService findStadiumService,
            CreateStadiumService createStadiumService
    ) {
        this.findStadiumService = findStadiumService;
        this.createStadiumService = createStadiumService;
    }

    @Operation(summary = "Create a stadium", description = "Registers a new stadium in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Stadium created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StadiumResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content)
    })
    @PostMapping
    public ResponseEntity<StadiumResponse> create(@RequestBody StadiumRequest stadiumRequest) {
        StadiumResponse stadiumResponse = this.createStadiumService.create(stadiumRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(stadiumResponse);
    }

    @Operation(summary = "List all stadiums", description = "Returns a paginated list of all registered stadiums")
    @ApiResponse(responseCode = "200", description = "Stadiums retrieved successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class)))
    @GetMapping
    public ResponseEntity<Page<StadiumResponse>> findAll(Pageable pageable) {
        Page<StadiumResponse> stadiums = this.findStadiumService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(stadiums);
    }
}
