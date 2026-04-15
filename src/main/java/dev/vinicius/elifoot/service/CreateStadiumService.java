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

    public CreateStadiumService(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    public StadiumResponse create(StadiumRequest stadiumRequest){
        Stadium stadium = this.stadiumRepository.save(StadiumMapper.toDomain(stadiumRequest));

        return StadiumMapper.toResponse(stadium);
    }

}
