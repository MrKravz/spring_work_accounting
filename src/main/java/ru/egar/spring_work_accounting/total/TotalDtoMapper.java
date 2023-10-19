package ru.egar.spring_work_accounting.total;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.egar.spring_work_accounting.abstraction.mappers.OneSidedIterableMapper;
import ru.egar.spring_work_accounting.bonus.BonusDtoMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = BonusDtoMapper.class)
public interface TotalDtoMapper extends OneSidedIterableMapper<Total, TotalDto> {
}
