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
        var employee = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        if (employee.getIsDeleted()) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    @Transactional
    public Long update(Employee employee, Long id) {
        var employeeToUpdate = findById(id);
        employeeToUpdate.setName(employee.getName());
        employeeToUpdate.setDateOfBirthDay(employee.getDateOfBirthDay());
        employeeToUpdate.setEmployeePosition(employee.getEmployeePosition());
        employeeToUpdate.setEmployeeGrade(employee.getEmployeeGrade());
        employeeToUpdate.setPaymentSystem(employee.getPaymentSystem());
        employeeToUpdate.setIsDeleted(employee.getIsDeleted());
        return save(employeeToUpdate);
    }


    @Override
    @Transactional
    public Long save(Employee employee) {
        var result = employeeRepository.save(employee);
        return result.getId();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var employeeToDelete = findById(id);
        employeeToDelete.setIsDeleted(true);
        update(employeeToDelete, id);
    }

}
