package dev.vinicius.elifoot.repository;

import dev.vinicius.elifoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
