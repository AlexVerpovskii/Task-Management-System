package ru.averpovskii.taskmanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.averpovskii.taskmanagement.entity.UserEntity;

@Component
@RequiredArgsConstructor
public class UserSecurityUtils {

    public Long getCurrentUserId() {
        var user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getId();
    }
}
