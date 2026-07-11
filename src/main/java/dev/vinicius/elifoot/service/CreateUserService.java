package dev.vinicius.elifoot.service;

import dev.vinicius.elifoot.controller.request.UserRequest;
import dev.vinicius.elifoot.controller.response.UserResponse;
import dev.vinicius.elifoot.entity.Scope;
import dev.vinicius.elifoot.entity.User;
import dev.vinicius.elifoot.expection.ResourceAlreadyExistsException;
import dev.vinicius.elifoot.mapper.UserMapper;
import dev.vinicius.elifoot.repository.ScopeRepository;
import dev.vinicius.elifoot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final UserRepository userRepository;
    private final ScopeRepository scopeRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserResponse create(UserRequest request) {
        if(this.userRepository.existsByEmail(request.getEmail())){
            throw new ResourceAlreadyExistsException("Email already in use, email: " + request.getEmail());
        }


        List<Scope> scopes = request.getScopeIds() == null ? List.of() :
                request.getScopeIds().stream()
                        .map(id -> scopeRepository.findById(UUID.fromString(id))
                                .orElseThrow(() -> new IllegalArgumentException("Scope not found: " + id)))
                        .toList();

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .active(true)
                .scopes(scopes)
                .build();

        User saved = userRepository.save(user);

        return userMapper.toResponse(saved);
    }
}
