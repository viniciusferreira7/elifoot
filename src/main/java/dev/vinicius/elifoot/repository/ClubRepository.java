package dev.vinicius.elifoot.repository;

import dev.vinicius.elifoot.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
