package ru.egar.spring_work_accounting.auth;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.egar.spring_work_accounting.abstraction.mappers.OneSidedMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegisterRequestMapper extends OneSidedMapper<RegisterRequest, Account> {
}
