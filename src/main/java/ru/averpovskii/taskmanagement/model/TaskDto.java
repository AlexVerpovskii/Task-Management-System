package ru.averpovskii.taskmanagement.model;

import lombok.Data;
import ru.averpovskii.taskmanagement.enums.Priority;
import ru.averpovskii.taskmanagement.enums.Status;

@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private UserDto author;
    private UserDto executor;
}
