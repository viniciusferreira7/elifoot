package dev.vinicius.elifoot.controller;

import dev.vinicius.elifoot.controller.response.ClubResponse;
import dev.vinicius.elifoot.service.FindClubService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/clubs")
public class ClubController {

    private final FindClubService findClubService

    public ClubController(FindClubService findClubService) {
        this.findClubService = findClubService;
    }

    @GetMapping
    public ResponseEntity<Page<ClubResponse>> findAll(Pageable pageable){
        Page<ClubResponse> clubResponses = this.findClubService.findAll(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(clubResponses);
    }

    @GetMapping("/{id}")
    public void finById(){
    }

    @PostMapping
    public void create(){

    }
}
