package ru.egar.spring_work_accounting.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.abstraction.services.CrudService;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeeService implements CrudService<Employee, UUID> {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee findById(UUID id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    @Transactional
    @Override
    public UUID update(Employee employee, UUID id) {
        return employeeRepository.save(employee).getId();
    }

    @Transactional
    @Override
    public UUID save(Employee employee) {
        return employeeRepository.save(employee).getId();
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        employeeRepository.deleteById(id);
    }

}
