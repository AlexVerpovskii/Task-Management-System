package ru.averpovskii.taskmanagement.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.averpovskii.taskmanagement.entity.UserEntity;
import ru.averpovskii.taskmanagement.model.UserDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "email", ignore = true)
    @Mapping(target = "password", ignore = true)
    UserDto toUserDto(UserEntity user);

    @Mapping(target = "id", ignore = true)
    UserEntity toUserEntity(UserDto userDto);
}
