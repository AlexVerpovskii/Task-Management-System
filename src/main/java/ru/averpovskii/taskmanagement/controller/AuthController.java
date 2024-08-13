package ru.averpovskii.taskmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.averpovskii.taskmanagement.TaskConstants;
import ru.averpovskii.taskmanagement.model.ValidationErrorException;
import ru.averpovskii.taskmanagement.model.UserDto;
import ru.averpovskii.taskmanagement.service.AuthenticationService;
import ru.averpovskii.taskmanagement.config.JwtService;
import ru.averpovskii.taskmanagement.service.UserService;

@RestController
@RequestMapping(TaskConstants.AUTH)
@RequiredArgsConstructor
public class AuthController {
    private final JwtService jwtService;
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping(TaskConstants.REGISTER)
    public String signUp(@RequestBody UserDto userDto) throws ValidationErrorException {
        return jwtService.generateToken(userService.save(userDto));
    }

    @GetMapping(TaskConstants.LOGIN)
    public String auth(@RequestBody UserDto userDto) {
        return authenticationService.login(userDto);
    }
}
