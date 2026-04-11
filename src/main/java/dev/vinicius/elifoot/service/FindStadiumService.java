package dev.vinicius.elifoot.service;

import dev.vinicius.elifoot.entity.Stadium;
import dev.vinicius.elifoot.repository.StadiumRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FindStadiumService {
    private final StadiumRepository stadiumRepository;

    public FindStadiumService(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    public Page<Stadium> findAll(Pageable pageable){
        return this.stadiumRepository.findAll(pageable);
    }
}
