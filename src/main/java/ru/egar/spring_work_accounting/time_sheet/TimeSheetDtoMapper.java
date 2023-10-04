package ru.egar.spring_work_accounting.time_sheet;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.egar.spring_work_accounting.abstraction.mappers.TwoSidedIterableMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TimeSheetDtoMapper extends TwoSidedIterableMapper<TimeSheet, TimeSheetDto> {
}
