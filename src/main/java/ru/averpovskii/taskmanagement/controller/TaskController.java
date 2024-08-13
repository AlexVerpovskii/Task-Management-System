package ru.averpovskii.taskmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.averpovskii.taskmanagement.TaskConstants;
import ru.averpovskii.taskmanagement.model.TaskDto;
import ru.averpovskii.taskmanagement.service.TaskService;


@RestController
@RequestMapping(TaskConstants.TASKS)
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping(TaskConstants.SLASH)
    public ResponseEntity<Slice<TaskDto>> readAll(final Pageable pageable) {
        return new ResponseEntity<>(service.readAll(pageable), HttpStatus.OK);
    }

    @PostMapping(value = TaskConstants.SLASH)
    public ResponseEntity<TaskDto> create(@RequestBody final TaskDto entity) {
        return new ResponseEntity<>(service.create(entity), HttpStatus.OK);
    }

    @PutMapping(value = TaskConstants.PATH_ID)
    public ResponseEntity<TaskDto> update(@RequestBody final TaskDto dto,
                                          @PathVariable(TaskConstants.ID) final Long id) {
        return new ResponseEntity<>(service.update(dto, id), HttpStatus.OK);
    }

    @DeleteMapping(value = TaskConstants.PATH_ID)
    public void delete(@PathVariable(TaskConstants.ID) final Long id) {
        service.delete(id);
    }
}
