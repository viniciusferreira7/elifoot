package dev.vinicius.elifoot.service;

import dev.vinicius.elifoot.controller.request.PlayerRequest;
import dev.vinicius.elifoot.controller.response.PlayerResponse;
import dev.vinicius.elifoot.entity.Player;
import dev.vinicius.elifoot.mapper.PlayerMapper;
import dev.vinicius.elifoot.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public PlayerResponse create(PlayerRequest playerRequest){
        Player player = this.playerRepository.save(this.playerMapper.toEntity(playerRequest));

        return this.playerMapper.toResponse(player);
    }
}
