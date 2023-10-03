package ru.egar.spring_work_accounting.total;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.egar.spring_work_accounting.abstraction.mappers.OneSidedIterableMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TotalDtoMapper extends OneSidedIterableMapper<Total, TotalDto> {
}
