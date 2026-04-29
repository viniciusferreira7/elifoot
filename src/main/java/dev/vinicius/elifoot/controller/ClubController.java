package dev.vinicius.elifoot.controller;

import dev.vinicius.elifoot.controller.request.ClubRequest;
import dev.vinicius.elifoot.controller.response.ClubDetailsResponse;
import dev.vinicius.elifoot.controller.response.ClubResponse;
import dev.vinicius.elifoot.controller.response.PlayerResponse;
import dev.vinicius.elifoot.service.CreateClubService;
import dev.vinicius.elifoot.service.FindClubService;
import dev.vinicius.elifoot.service.FindPlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@RequestMapping("api/clubs")
@Tag(name = "Clubs", description = "Club management API")
public class ClubController {

    private final FindClubService findClubService;
    private final FindPlayerService findPlayerService;
    private final CreateClubService createClubService;

    public ClubController(FindClubService findClubService, FindPlayerService findPlayerService, CreateClubService createClubService) {
        this.findClubService = findClubService;
        this.findPlayerService = findPlayerService;
        this.createClubService = createClubService;
    }

    @Operation(summary = "List all clubs", description = "Returns a paginated list of all registered clubs")
    @ApiResponse(responseCode = "200", description = "Clubs retrieved successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class)))
    @GetMapping
    public ResponseEntity<Page<ClubResponse>> findAll(Pageable pageable) {
        Page<ClubResponse> clubResponses = this.findClubService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(clubResponses);
    }

    @Operation(summary = "Find club by ID", description = "Returns the full details of a club given its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Club found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClubDetailsResponse.class))),
            @ApiResponse(responseCode = "404", description = "Club not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ClubDetailsResponse> finById(
            @Parameter(description = "Club UUID", required = true) @PathVariable String id) {
        return this.findClubService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a club", description = "Registers a new club in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Club created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClubDetailsResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Stadium not found", content = @Content)
    })
    @PostMapping
    public ResponseEntity<ClubDetailsResponse> create(@RequestBody ClubRequest clubRequest) {
        ClubDetailsResponse clubDetailsResponse = this.createClubService.create(clubRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(clubDetailsResponse);
    }

    @GetMapping("/{id}/players")
    public ResponseEntity<Page<PlayerResponse>> findPlayersByClubId(@PathVariable("id") String clubId, Pageable pageable){
        Page<PlayerResponse> playerResponses = this.findPlayerService.findPlayerByClubId(clubId, pageable);

        return ResponseEntity.status(HttpStatus.OK).body(playerResponses);
    }
}
