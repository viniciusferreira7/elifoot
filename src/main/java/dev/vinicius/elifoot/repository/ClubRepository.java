package dev.vinicius.elifoot.repository;

import dev.vinicius.elifoot.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClubRepository extends JpaRepository<Club, UUID> {
}
