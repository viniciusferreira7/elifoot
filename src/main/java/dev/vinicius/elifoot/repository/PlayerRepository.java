package dev.vinicius.elifoot.repository;

import dev.vinicius.elifoot.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
    Page<Player> findByClubId(UUID clubId, Pageable pageable);
}
