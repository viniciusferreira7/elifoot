package dev.vinicius.elifoot.service;

import dev.vinicius.elifoot.controller.response.ClubDetailsResponse;
import dev.vinicius.elifoot.controller.response.ClubResponse;
import dev.vinicius.elifoot.mapper.ClubMapper;
import dev.vinicius.elifoot.repository.ClubRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindClubService {
    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;

    public FindClubService(ClubRepository clubRepository, ClubMapper clubMapper) {
        this.clubRepository = clubRepository;
        this.clubMapper = clubMapper;
    }

    public Page<ClubResponse> findAll(Pageable pageable){
        return this.clubRepository.findAll(pageable).map(this.clubMapper::toResponse);
    }

    public Optional<ClubDetailsResponse> findById(String clubId){
        return this.clubRepository
                .findById(UUID.fromString(clubId))
                .map(this.clubMapper::toDetailsResponse);
    }
}