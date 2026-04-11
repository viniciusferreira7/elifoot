package dev.vinicius.elifoot.controller;

import dev.vinicius.elifoot.controller.response.StadiumResponse;
import dev.vinicius.elifoot.entity.Stadium;
import dev.vinicius.elifoot.service.FindStadiumService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stadiums")
public class StadiumController {
    private final FindStadiumService findStadiumService;

    public StadiumController(FindStadiumService findStadiumService) {
        this.findStadiumService = findStadiumService;
    }

    @GetMapping
    public ResponseEntity<Page<StadiumResponse>> findAll(Pageable pageable){
        Page<StadiumResponse> stadiums = this.findStadiumService.findAll(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(stadiums);
    }
}
