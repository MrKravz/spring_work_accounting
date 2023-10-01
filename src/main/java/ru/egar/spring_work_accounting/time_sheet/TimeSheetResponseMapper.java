package ru.egar.spring_work_accounting.time_sheet;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.egar.spring_work_accounting.abstraction.mappers.OneSidedMapper;
import ru.egar.spring_work_accounting.employee.EmployeeDtoMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = EmployeeDtoMapper.class)
public interface TimeSheetResponseMapper extends OneSidedMapper<TimeSheet, TimeSheetResponse> {
}
