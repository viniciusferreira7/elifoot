package dev.vinicius.elifoot.controller;

import dev.vinicius.elifoot.controller.request.ClubRequest;
import dev.vinicius.elifoot.controller.response.ClubDetailsResponse;
import dev.vinicius.elifoot.controller.response.ClubResponse;
import dev.vinicius.elifoot.service.CreateClubService;
import dev.vinicius.elifoot.service.FindClubService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/clubs")
public class ClubController {

    private final FindClubService findClubService;
    private final CreateClubService createClubService;

    public ClubController(FindClubService findClubService, CreateClubService createClubService) {
        this.findClubService = findClubService;
        this.createClubService = createClubService;
    }

    @GetMapping
    public ResponseEntity<Page<ClubResponse>> findAll(Pageable pageable){
        Page<ClubResponse> clubResponses = this.findClubService.findAll(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(clubResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubDetailsResponse> finById(@PathVariable String id){
        return this.findClubService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClubDetailsResponse> create(@RequestBody ClubRequest clubRequest){
        ClubDetailsResponse clubDetailsResponse = this.createClubService.create(clubRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(clubDetailsResponse);
    }
}
