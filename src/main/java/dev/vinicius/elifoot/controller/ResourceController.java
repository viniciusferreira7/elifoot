package dev.vinicius.elifoot.controller;

import dev.vinicius.elifoot.controller.response.PositionResponse;
import dev.vinicius.elifoot.entity.Position;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/resources")
@Tag(name = "Resources", description = "Static resource lookup API")
public class ResourceController {

    @Operation(summary = "List all positions", description = "Returns all available player positions with their display labels")
    @ApiResponse(responseCode = "200", description = "Positions retrieved successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PositionResponse.class)))
    @GetMapping("/positions")
    public ResponseEntity<List<PositionResponse>> findAllPositions(){
        List<PositionResponse> positions = Arrays.stream(Position.values()).map((position) -> new PositionResponse(position.name(), position.getLabel())).toList();

        return ResponseEntity.status((HttpStatus.OK)).body(positions);
    }
}
