package dev.vinicius.elifoot.service;

import dev.vinicius.elifoot.controller.request.UserRequest;
import dev.vinicius.elifoot.expection.ResourceAlreadyExistsException;
import dev.vinicius.elifoot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateUserServiceTest {
    @InjectMocks
    CreateUserService createUserService;

    @Mock
    UserRepository userRepository;

    @Test
    void shouldThrowExceptionWhenEmailAlreadyExists(){
        UserRequest userRequest = UserRequest.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("123Mudar")
                .build();

        Mockito.when(this.userRepository.existsByEmail(userRequest.getEmail())).thenReturn(true);

        ResourceAlreadyExistsException resourceAlreadyExistsException = assertThrows(
                ResourceAlreadyExistsException.class,
                () -> this.createUserService.create(userRequest)
        );

        assertEquals("Email already in use, email: " + userRequest.getEmail(), resourceAlreadyExistsException.getMessage());
    }


}