package dev.vinicius.elifoot.service;

import dev.vinicius.elifoot.controller.request.ClubRequest;
import dev.vinicius.elifoot.controller.response.ClubDetailsResponse;
import dev.vinicius.elifoot.entity.Club;
import dev.vinicius.elifoot.expection.ResourceNotFoundException;
import dev.vinicius.elifoot.mapper.ClubMapper;
import dev.vinicius.elifoot.repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CreateClubService {
    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;
    private final FindStadiumService findStadiumService;

    public CreateClubService(ClubRepository clubRepository, ClubMapper clubMapper, FindStadiumService findStadiumService) {
        this.clubRepository = clubRepository;
        this.clubMapper = clubMapper;
        this.findStadiumService = findStadiumService;
    }

    public ClubDetailsResponse create(ClubRequest clubRequest){
        if (Objects.nonNull(clubRequest.getStadiumId())) {
            this.findStadiumService
                    .findById(clubRequest.getStadiumId().toString())
                    .orElseThrow(() -> new ResourceNotFoundException("Stadium not found"));
        }

        Club club = this.clubRepository.save(
                this.clubMapper.toDomain(clubRequest)
        );


        return this.clubMapper.toDetailsResponse(club);
    }
}
