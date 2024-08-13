package ru.averpovskii.taskmanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.averpovskii.taskmanagement.TaskConstants;
import ru.averpovskii.taskmanagement.model.ValidationErrorException;
import ru.averpovskii.taskmanagement.converter.UserMapper;
import ru.averpovskii.taskmanagement.entity.UserEntity;
import ru.averpovskii.taskmanagement.model.UserDto;
import ru.averpovskii.taskmanagement.repository.UserRepository;

import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class UserService {
    private static final Pattern REGEX_FOR_EMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    private final UserRepository repository;
    private final UserMapper mapper;
    private final TaskValidator taskValidator;

    public UserEntity save(UserDto userDto) throws ValidationErrorException {
        taskValidator.assertTrue(TaskConstants.INVALID_EMAIL, REGEX_FOR_EMAIL.matcher(userDto.getEmail()).matches());
        final var user = repository.findByEmail(userDto.getEmail());
        taskValidator.assertIsNull(TaskConstants.USER_IS_EXIST, user);
        return repository.save(mapper.toUserEntity(userDto));
    }

    public UserEntity loadUserByUsername(String email) throws UsernameNotFoundException {

        final var user = repository.findByEmail(email);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException(email);
        }

        return user.get();
    }
}
