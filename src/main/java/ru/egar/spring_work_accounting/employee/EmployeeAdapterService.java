package ru.egar.spring_work_accounting.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egar.spring_work_accounting.abstraction.services.CrudAdapterService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeAdapterService implements CrudAdapterService<EmployeeRequest, EmployeeResponse, UUID> {

    private final EmployeeService employeeService;
    private final EmployeeRequestMapper employeeRequestMapper;
    private final EmployeeResponseMapper employeeResponseMapper;

    @Override
    public EmployeeResponse findById(UUID id) {
        return employeeResponseMapper.map(employeeService.findById(id));
    }

    @Override
    public UUID save(EmployeeRequest entity) {
        return employeeService.save(employeeRequestMapper.map(entity));
    }

    @Override
    public UUID update(EmployeeRequest entity, UUID id) {
        return employeeService.update(employeeRequestMapper.map(entity), id);
    }

    @Override
    public void delete(UUID id) {
        employeeService.delete(id);
    }

}
