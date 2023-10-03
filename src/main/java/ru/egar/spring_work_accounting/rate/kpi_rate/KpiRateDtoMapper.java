package ru.egar.spring_work_accounting.rate.kpi_rate;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.egar.spring_work_accounting.abstraction.mappers.OneSidedMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface KpiRateDtoMapper extends OneSidedMapper<KpiRate, KpiRateDto> {
}
