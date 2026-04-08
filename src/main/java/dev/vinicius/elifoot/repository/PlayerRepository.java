package dev.vinicius.elifoot.repository;

import dev.vinicius.elifoot.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
