package ru.egar.spring_work_accounting.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.employee.Employee;
import ru.egar.spring_work_accounting.employee.EmployeeNotFoundException;
import ru.egar.spring_work_accounting.employee.EmployeeRepository;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee findById(UUID id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    @Transactional
    public UUID update(Employee employee, UUID id) {
        return employeeRepository.save(employee).getId();
    }

    @Transactional
    public UUID create(Employee employee) {
        return employeeRepository.save(employee).getId();
    }

    @Transactional
    public void delete(UUID id) {
        employeeRepository.deleteById(id);
    }

}
