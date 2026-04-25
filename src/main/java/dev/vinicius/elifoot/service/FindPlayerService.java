package dev.vinicius.elifoot.service;

import dev.vinicius.elifoot.controller.response.PlayerDetailsResponse;
import dev.vinicius.elifoot.controller.response.PlayerResponse;
import dev.vinicius.elifoot.mapper.PlayerMapper;
import dev.vinicius.elifoot.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindPlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public Page<PlayerResponse> findAll(Pageable pageable){
        return this.playerRepository.findAll(pageable).map(this.playerMapper::toResponse);
    }

    public Optional<PlayerDetailsResponse> findById(String playerId){
        return this.playerRepository
                .findById(UUID.fromString(playerId))
                .map(this.playerMapper::toDetailsResponse);
    }
}
