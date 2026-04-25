package dev.vinicius.elifoot.controller;

import dev.vinicius.elifoot.controller.request.PlayerRequest;
import dev.vinicius.elifoot.controller.response.PlayerDetailsResponse;
import dev.vinicius.elifoot.controller.response.PlayerResponse;
import dev.vinicius.elifoot.service.CreatePlayerService;
import dev.vinicius.elifoot.service.FindPlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
@Tag(name = "Players", description = "Player management API")
public class PlayerController {

    private final CreatePlayerService createPlayerService;
    private final FindPlayerService findPlayerService;

    @Operation(summary = "Create a player", description = "Registers a new player and assigns them to a club")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Player created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PlayerResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Club not found", content = @Content)
    })
    @PostMapping
    public ResponseEntity<PlayerResponse> create(@RequestBody PlayerRequest playerRequest) {
        PlayerResponse playerResponse = this.createPlayerService.create(playerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(playerResponse);
    }

    @Operation(summary = "List all players", description = "Returns a paginated list of all registered players")
    @ApiResponse(responseCode = "200", description = "Players retrieved successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class)))
    @GetMapping
    public ResponseEntity<Page<PlayerResponse>> findAll(Pageable pageable) {
        Page<PlayerResponse> playerResponses = this.findPlayerService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(playerResponses);
    }

    @Operation(summary = "Find player by ID", description = "Returns the full details of a player given their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Player found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PlayerDetailsResponse.class))),
            @ApiResponse(responseCode = "404", description = "Player not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<PlayerDetailsResponse> findById(
            @Parameter(description = "Player UUID", required = true) @PathVariable String id) {
        return this.findPlayerService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
