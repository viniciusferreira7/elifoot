package dev.vinicius.elifoot.controller;

import dev.vinicius.elifoot.controller.request.StadiumRequest;
import dev.vinicius.elifoot.controller.response.StadiumResponse;
import dev.vinicius.elifoot.entity.Stadium;
import dev.vinicius.elifoot.service.CreateStadiumService;
import dev.vinicius.elifoot.service.FindStadiumService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stadiums")
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

    @PostMapping
    public  ResponseEntity<StadiumResponse> create(@RequestBody StadiumRequest stadiumRequest){
        StadiumResponse stadiumResponse = this.createStadiumService.create(stadiumRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(stadiumResponse);
    }

    @GetMapping
    public ResponseEntity<Page<StadiumResponse>> findAll(Pageable pageable){
        Page<StadiumResponse> stadiums = this.findStadiumService.findAll(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(stadiums);
    }
}
