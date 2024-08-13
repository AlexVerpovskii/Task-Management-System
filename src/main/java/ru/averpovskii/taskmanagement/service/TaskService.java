package ru.averpovskii.taskmanagement.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;
import ru.averpovskii.taskmanagement.model.TaskDto;

public interface TaskService {
    @Transactional
    TaskDto create(TaskDto taskDto);

    @Transactional
    TaskDto update(TaskDto taskDto, Long id);

    @Transactional
    void delete(Long id);

    @Transactional(readOnly = true)
    Slice<TaskDto> readAll(Pageable pageable);
}
