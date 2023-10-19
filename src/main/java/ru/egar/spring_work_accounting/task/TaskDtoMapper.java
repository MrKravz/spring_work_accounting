package ru.egar.spring_work_accounting.task;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.egar.spring_work_accounting.abstraction.mappers.TwoSidedIterableMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskDtoMapper extends TwoSidedIterableMapper<Task, TaskDto> {
}
