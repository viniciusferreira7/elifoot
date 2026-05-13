package dev.vinicius.elifoot.service;

import dev.vinicius.elifoot.controller.request.LoginRequest;
import dev.vinicius.elifoot.controller.response.LoginResponse;
import dev.vinicius.elifoot.entity.Scope;
import dev.vinicius.elifoot.entity.User;
import dev.vinicius.elifoot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class LoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtEncoder jwtEncoder;

    public LoginResponse login(LoginRequest loginRequest){
        Optional<User> optionalUser = this.userRepository.findByEmail(loginRequest.getEmail());

        if(optionalUser.isEmpty() || this.isPasswordCorrect(loginRequest.getPassword(), optionalUser.get().getPassword())){
            throw  new BadCredentialsException("User or password are incorrect");
        }

        User savedUser = optionalUser.get();

        List<String> scopes = savedUser.getScopes().stream().map(Scope::getName).toList();

        long expiresIn = 600L;

        JwtClaimsSet jwt = JwtClaimsSet.builder()
                .issuer("elifoot-api")
                .subject(savedUser.getName())
                .expiresAt(Instant.now().plusSeconds(expiresIn))
                .issuedAt(Instant.now())
                .claim("email", savedUser.getEmail())
                .claim("scope", scopes)
                .build();

        String token = jwtEncoder.encode(JwtEncoderParameters.from(jwt)).getTokenValue();

        return LoginResponse.builder().accessToken(token).expiresIn(expiresIn).build();
    }

    private Boolean isPasswordCorrect(String password, String savedPassword){

        return this.passwordEncoder.matches(password, savedPassword);
    }
}
