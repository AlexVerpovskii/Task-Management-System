package ru.averpovskii.taskmanagement.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import ru.averpovskii.taskmanagement.TaskConstants;
import ru.averpovskii.taskmanagement.converter.TaskMapper;
import ru.averpovskii.taskmanagement.model.TaskDto;
import ru.averpovskii.taskmanagement.repository.TaskRepository;
import ru.averpovskii.taskmanagement.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;
    private final UserRepository userRepository;
    private final TaskMapper mapper;
    private final TaskValidator validator;
    private final UserSecurityUtils userSecurityUtils;

    @Override
    public Slice<TaskDto> readAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public TaskDto create(TaskDto taskDto) {
        final var task = mapper.toEntity(taskDto);
        final var executor = userRepository.findById(taskDto.getExecutor().getId())
                .orElseThrow(EntityNotFoundException::new);
        task.setExecutor(executor);
        final var author = userRepository.findById(userSecurityUtils.getCurrentUserId())
                .orElseThrow(EntityNotFoundException::new);
        task.setAuthor(author);
        repository.save(task);
        return mapper.toDto(task);
    }

    @Override
    public TaskDto update(TaskDto taskDto, Long id) {
        final var originalTask = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        taskDto.setId(id);
        final var currentUserId = userSecurityUtils.getCurrentUserId();
        validator.assertEquals(TaskConstants.USER_ERROR, currentUserId, originalTask.getAuthor().getId());
        final var task = mapper.merge(taskDto, originalTask);
        final var executor = userRepository.findById(taskDto.getExecutor().getId())
                .orElseThrow(EntityNotFoundException::new);
        task.setExecutor(executor);
        repository.save(task);
        return mapper.toDto(task);

    }

    @Override
    public void delete(Long id) {
        validator.assertEquals(TaskConstants.USER_ERROR, 1L, 1L);
        final var task = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        repository.delete(task);
    }
}
