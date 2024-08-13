package ru.averpovskii.taskmanagement.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.averpovskii.taskmanagement.config.JwtService;
import ru.averpovskii.taskmanagement.model.UserDto;
import ru.averpovskii.taskmanagement.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public String login(UserDto user) {
        var userEntity = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword())
                .orElseThrow(EntityNotFoundException::new);
        return jwtService.generateToken(userEntity);
    }
}
