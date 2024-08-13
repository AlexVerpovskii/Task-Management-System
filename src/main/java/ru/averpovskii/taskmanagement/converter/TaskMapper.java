package ru.averpovskii.taskmanagement.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import ru.averpovskii.taskmanagement.entity.TaskEntity;
import ru.averpovskii.taskmanagement.model.TaskDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface TaskMapper {

    TaskDto toDto(TaskEntity task);

    @Mapping(target = "author", ignore = true)
    @Mapping(target = "executor", ignore = true)
    @Mapping(target = "id", ignore = true)
    TaskEntity toEntity(TaskDto taskDto);

    @Mapping(target = "author", ignore = true)
    @Mapping(target = "executor", ignore = true)
    TaskEntity merge(TaskDto taskDto, @MappingTarget TaskEntity task);
}
