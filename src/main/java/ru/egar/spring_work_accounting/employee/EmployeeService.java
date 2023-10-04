package ru.egar.spring_work_accounting.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.abstraction.services.CrudService;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeeService implements CrudService<Employee, Long> {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    @Transactional
    @Override
    public Long update(Employee employee, Long id) {
        return employeeRepository.save(employee).getId();
    }


    @Override
    @Transactional
    public Long save(Employee employee) {
        var result = employeeRepository.save(employee);
        return result.getId();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

}
