package ru.egar.spring_work_accounting.employee;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.egar.spring_work_accounting.abstraction.mappers.TwoSidedIterableMapper;
import ru.egar.spring_work_accounting.rate.hour_rate.HourRateDtoMapper;
import ru.egar.spring_work_accounting.rate.kpi_rate.KpiRateDtoMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {HourRateDtoMapper.class,
        KpiRateDtoMapper.class})
public interface EmployeeDtoMapper extends TwoSidedIterableMapper<Employee, EmployeeDto> {
}
