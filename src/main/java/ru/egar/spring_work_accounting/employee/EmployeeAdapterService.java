package ru.egar.spring_work_accounting.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egar.spring_work_accounting.abstraction.services.CrudAdapterService;

@Service
@RequiredArgsConstructor
public class EmployeeAdapterService implements CrudAdapterService<EmployeeRequest, EmployeeResponse, Long> {

    private final EmployeeService employeeService;
    private final EmployeeRequestMapper employeeRequestMapper;
    private final EmployeeResponseMapper employeeResponseMapper;

    @Override
    public EmployeeResponse findById(Long id) {
        return employeeResponseMapper.map(employeeService.findById(id));
    }

    @Override
    public Long save(EmployeeRequest entity) {
        return employeeService.save(employeeRequestMapper.map(entity));
    }

    @Override
    public Long update(EmployeeRequest entity, Long id) {
        return employeeService.update(employeeRequestMapper.map(entity), id);
    }

    @Override
    public void delete(Long id) {
        employeeService.delete(id);
    }

}
