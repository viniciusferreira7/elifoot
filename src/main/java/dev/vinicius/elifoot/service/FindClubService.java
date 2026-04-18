package dev.vinicius.elifoot.service;

import dev.vinicius.elifoot.controller.response.ClubResponse;
import dev.vinicius.elifoot.mapper.ClubMapper;
import dev.vinicius.elifoot.repository.ClubRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}