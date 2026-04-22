package dev.vinicius.elifoot.service;

import dev.vinicius.elifoot.controller.response.ClubDetailsResponse;
import dev.vinicius.elifoot.controller.response.StadiumResponse;
import dev.vinicius.elifoot.mapper.StadiumMapper;
import dev.vinicius.elifoot.repository.StadiumRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindStadiumService {
    private final StadiumRepository stadiumRepository;
    private final StadiumMapper stadiumMapper;

    public FindStadiumService(StadiumRepository stadiumRepository, StadiumMapper stadiumMapper) {
        this.stadiumRepository = stadiumRepository;
        this.stadiumMapper = stadiumMapper;
    }

    public Page<StadiumResponse> findAll(Pageable pageable){
        return this.stadiumRepository.findAll(pageable).map(this.stadiumMapper::toResponse);
    }

    public Optional<StadiumResponse> findById(String stadiumId){
        return this.stadiumRepository
                .findById(UUID.fromString(stadiumId))
                .map(this.stadiumMapper::toResponse);
    }
}
