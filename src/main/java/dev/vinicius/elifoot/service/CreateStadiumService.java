package dev.vinicius.elifoot.service;

import dev.vinicius.elifoot.controller.request.StadiumRequest;
import dev.vinicius.elifoot.controller.response.StadiumResponse;
import dev.vinicius.elifoot.entity.Stadium;
import dev.vinicius.elifoot.mapper.StadiumMapper;
import dev.vinicius.elifoot.repository.StadiumRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateStadiumService {
    private final StadiumRepository stadiumRepository;
    private final StadiumMapper stadiumMapper;

    public CreateStadiumService(StadiumRepository stadiumRepository, StadiumMapper stadiumMapper) {
        this.stadiumRepository = stadiumRepository;
        this.stadiumMapper = stadiumMapper;
    }

    public StadiumResponse create(StadiumRequest stadiumRequest){
        Stadium stadium = this.stadiumRepository.save(this.stadiumMapper.toDomain(stadiumRequest));

        return this.stadiumMapper.toResponse(stadium);
    }

}
