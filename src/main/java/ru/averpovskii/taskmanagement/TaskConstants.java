package ru.averpovskii.taskmanagement;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskConstants {
    public static final String TASKS = "/tasks";
    public static final String REGISTER = "/register";
    public static final String LOGIN = "/login";
    public static final String SLASH = "/";
    public static final String PATH_ID = "{id}";
    public static final String ID = "id";
    public static final String USER_ERROR = "Для указанного задания действия редактирования/удаления запрещены";
    public static final String AUTH = "/auth";
    public static final String USER_IS_EXIST = "Пользователь с таким email уже существует";
    public static final String INVALID_EMAIL = "Неверно указан email";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final String EMAIL = "email";
}
