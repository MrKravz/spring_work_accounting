package ru.egar.spring_work_accounting.total;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.abstraction.services.CrudService;
import ru.egar.spring_work_accounting.employee.Employee;
import ru.egar.spring_work_accounting.employee.EmployeeNotFoundException;
import ru.egar.spring_work_accounting.employee.EmployeeRepository;
import ru.egar.spring_work_accounting.time_sheet.TimeSheetNotFoundException;

import java.time.LocalDate;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TotalService implements CrudService<Total, Long> {

    private final ComputeTotalService computeTotalService;
    private final EmployeeRepository employeeRepository;
    private final TotalRepository totalRepository;

    public Total findById(Long id) {
        var result = totalRepository.findById(id).orElseThrow(TotalNotFoundException::new);
        if (result.getIsDeleted()) {
            throw new TotalNotFoundException();
        }
        return result;
    }

    @Transactional
    public Long update(Total entity, Long id) {
        var totalToUpdate = findById(id);
        totalToUpdate.setKpiPercentage(entity.getKpiPercentage());
        totalToUpdate.setTotalWorkedTime(entity.getTotalWorkedTime());
        totalToUpdate.setTotalSalary(entity.getTotalSalary());
        totalToUpdate.setIsDeleted(entity.getIsDeleted());
        totalToUpdate.setBonus(entity.getBonus());
        return totalRepository.save(totalToUpdate).getId();
    }

    @Transactional
    public Long save(Total total) {
        total.setIsDeleted(false);
        return totalRepository.save(total).getId();
    }

    @Transactional
    public void delete(Long id) {
        var result = findById(id);
        result.setIsDeleted(true);
        update(result, id);
    }

    @Transactional
    Long generateTotal(GenerateTotalRequest generateTotalRequest) {
        var employee = employeeRepository.findById(generateTotalRequest.getEmployeeId());
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        var startDate = defineStartDate(employee.get());
        var endDate = LocalDate.now();
        Total total = computeTotalService.computeTotal(employee.get(), startDate, endDate);
        return save(total);
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

}
