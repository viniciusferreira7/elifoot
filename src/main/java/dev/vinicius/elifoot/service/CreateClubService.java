package dev.vinicius.elifoot.service;

import dev.vinicius.elifoot.controller.request.ClubRequest;
import dev.vinicius.elifoot.controller.response.ClubDetailsResponse;
import dev.vinicius.elifoot.controller.response.ClubResponse;
import dev.vinicius.elifoot.entity.Club;
import dev.vinicius.elifoot.mapper.ClubMapper;
import dev.vinicius.elifoot.repository.ClubRepository;

public class CreateClubService {
    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;

    public CreateClubService(ClubRepository clubRepository, ClubMapper clubMapper) {
        this.clubRepository = clubRepository;
        this.clubMapper = clubMapper;
    }

    public ClubDetailsResponse create(ClubRequest clubRequest){
        Club club = this.clubRepository.save(this.clubMapper.toDomain(clubRequest));

        return this.clubMapper.toDetailsResponse(club);
    }
}
