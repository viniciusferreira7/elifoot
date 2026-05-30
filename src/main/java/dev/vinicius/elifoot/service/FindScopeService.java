package dev.vinicius.elifoot.service;

import dev.vinicius.elifoot.entity.Scope;
import dev.vinicius.elifoot.repository.ScopeRepository;
import io.swagger.v3.oas.annotations.servers.Servers;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@Servers
@RequiredArgsConstructor
public class FindScopeService {
    private final ScopeRepository scopeRepository;

    public Optional<Scope> findById(String scopeId){
        return this.scopeRepository.findById(UUID.fromString(scopeId));
    }
}
