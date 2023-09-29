package ru.egar.spring_work_accounting.total;

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
public class TotalService {

    private final ComputeTotalService computeTotalService;
    private final EmployeeRepository employeeRepository;
    private final TotalRepository totalRepository;

    public Total findById(UUID id) {
        return totalRepository.findById(id).orElseThrow(TotalNotFoundException::new);
    }

    @Transactional
    public UUID createTotal(UUID employeeId) {
        var employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        var total = generateTotal(employee.get());
        return totalRepository.save(total).getId();
    }

    private Total generateTotal(Employee employee) {
        var lastTotal = totalRepository.findTopByEmployeeOrderByIdDesc(employee)
                .orElseThrow(TotalNotFoundException::new);
        final long daysIncrement = 1;
        var startDate = lastTotal.getDate().plusDays(daysIncrement);
        var endDate = startDate.plusDays(startDate.lengthOfMonth()); // TODO maybe consider LocalDate.now()
        return computeTotalService.computeTotal(employee, startDate, endDate);
    }

    @Transactional
    public void delete(UUID id) {
        totalRepository.deleteById(id);
    }

}
