package ru.egar.spring_work_accounting.total;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.employee.Employee;
import ru.egar.spring_work_accounting.employee.EmployeeNotFoundException;
import ru.egar.spring_work_accounting.employee.EmployeeRepository;
import ru.egar.spring_work_accounting.time_sheet.TimeSheetNotFoundException;

import java.time.LocalDate;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TotalService {

    private final ComputeTotalService computeTotalService;
    private final EmployeeRepository employeeRepository;
    private final TotalRepository totalRepository;
    private final TotalDtoMapper totalDtoMapper;

    public TotalDto findById(Long id) {
        var result = totalRepository.findById(id).orElseThrow(TotalNotFoundException::new);
        return totalDtoMapper.map(result);
    }

    @Transactional
    public Long createTotal(TotalRequest totalRequest) {
        var employee = employeeRepository.findById(totalRequest.getEmployeeId());
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        var total = generateTotal(employee.get());
        var savedTotal = totalRepository.save(total);
        return savedTotal.getId();
    }

    private Total generateTotal(Employee employee) {
        var startDate = defineStartDate(employee);
        var endDate = LocalDate.now();
        return computeTotalService.computeTotal(employee, startDate, endDate);
    }

    private LocalDate defineStartDate(Employee employee) {
        if (!employee.getTotals().isEmpty()) {
            var lastTotal = totalRepository.findTopByEmployeeOrderByIdDesc(employee)
                    .orElseThrow(TotalNotFoundException::new);
            final long daysIncrement = 1;
            return lastTotal.getDate().plusDays(daysIncrement);
        }
        var timeSheets = employee.getTimeSheets().stream().findFirst();
        return timeSheets.orElseThrow(TimeSheetNotFoundException::new).getDate();
    }

    @Transactional
    public void delete(Long id) {
        totalRepository.deleteById(id);
    }

}
