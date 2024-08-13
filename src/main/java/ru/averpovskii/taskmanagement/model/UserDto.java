package ru.averpovskii.taskmanagement.model;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private String nickname;
}
