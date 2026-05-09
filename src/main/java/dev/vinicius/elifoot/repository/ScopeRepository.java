package dev.vinicius.elifoot.repository;

import dev.vinicius.elifoot.entity.Scope;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScopeRepository extends JpaRepository<Scope, UUID> {
}
