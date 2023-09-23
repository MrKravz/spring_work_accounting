package ru.egar.spring_work_accounting.total;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.compute.time.ComputeTimeService;
import ru.egar.spring_work_accounting.define.salary_strategy.DefineComputeSalaryService;
import ru.egar.spring_work_accounting.employee.Employee;
import ru.egar.spring_work_accounting.employee.EmployeeNotFoundException;
import ru.egar.spring_work_accounting.employee.EmployeeRepository;
import ru.egar.spring_work_accounting.time_sheet.TimeSheetRepository;
import ru.egar.spring_work_accounting.time_sheet.TimeStatus;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Compute total for employee between start and end dates.
 * Uses both ComputeTimeService for computing spent time and
 * ComputeSalaryService for computing salary by that time and employee rate.
 **/
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ComputeTotalService {
    private final ComputeTimeService computeTimeService;
    private final EmployeeRepository employeeRepository;
    private final DefineComputeSalaryService defineComputeSalaryService;
    private final TimeSheetRepository timeSheetRepository;
    private final int totalAbsentTime = 0;
    private int kpiPercentage;

    public Total computeTotal(UUID employeeId, LocalDate dateStart, LocalDate dateEnd) {
        var employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        int totalWorkedTime = 0;
        var timeStatuses = timeSheetRepository.findDistinctByTimeStatus();
        for (var timeStatus : timeStatuses) {
            totalWorkedTime += computeTotalTime(timeStatus, employee.get(), dateStart, dateEnd);
        }
        var strategy = defineComputeSalaryService.defineStrategy(employee.get().getPaymentSystem());
        float totalSalary = strategy.computeSalary(employee.get(), dateStart, dateEnd);
        return new Total(UUID.randomUUID(), totalWorkedTime, kpiPercentage, totalSalary, LocalDate.now(), employee.get());
    }

    /**
     * Sub method for compute total. Created to make logic more clear and understandable.
     * Set total times and returns them depending on time status.
     **/
    private int computeTotalTime(TimeStatus timeStatus, Employee employee, LocalDate dateStart, LocalDate dateEnd) {
        var timeSpan = computeTimeService.computeTime(employee, timeStatus, dateStart, dateEnd);
        if (timeStatus.equals(TimeStatus.Absence) || timeStatus.equals(TimeStatus.SickDays) ||
        timeStatus.equals(TimeStatus.Vacation)) {
            return totalAbsentTime;
        }
        return timeSpan;
    }

}
