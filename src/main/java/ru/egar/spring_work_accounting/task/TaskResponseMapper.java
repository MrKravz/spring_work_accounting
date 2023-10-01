package ru.egar.spring_work_accounting.task;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.egar.spring_work_accounting.abstraction.mappers.OneSidedIterableMapper;
import ru.egar.spring_work_accounting.employee.EmployeeDtoMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = EmployeeDtoMapper.class)
public interface TaskResponseMapper extends OneSidedIterableMapper<Task, TaskResponse> {
}
