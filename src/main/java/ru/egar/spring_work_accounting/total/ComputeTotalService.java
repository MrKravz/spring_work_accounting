package ru.egar.spring_work_accounting.total;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.compute.kpi.ComputeKpiService;
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
    private final ComputeKpiService computeKpiService;
    private final EmployeeRepository employeeRepository;
    private final DefineComputeSalaryService defineComputeSalaryService;
    private final TimeSheetRepository timeSheetRepository;

    public Total computeTotal(UUID employeeId, LocalDate dateStart, LocalDate dateEnd) {
        var employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        var timeStatuses = timeSheetRepository.findDistinctByTimeStatus();
        int totalWorkedTime = timeStatuses.stream().mapToInt(x -> computeTotalTime(x, employee.get(), dateStart, dateEnd)).sum();
        var strategy = defineComputeSalaryService.defineStrategy(employee.get().getPaymentSystem());
        final float totalSalary = strategy.computeSalary(employee.get(), dateStart, dateEnd);
        final int kpiPercentage = computeKpiService.computeKpi(employee.get(), dateStart, dateEnd);
        return new Total(UUID.randomUUID(), totalWorkedTime, kpiPercentage, totalSalary, LocalDate.now(), employee.get());
    }

    /**
     * Sub method for compute total. Created to make logic more clear and understandable.
     * Set total times and returns them depending on time status.
     **/
    private int computeTotalTime(TimeStatus timeStatus, Employee employee, LocalDate dateStart, LocalDate dateEnd) {
        final int totalAbsentTime = 0;
        var timeSpan = computeTimeService.computeTime(employee, timeStatus, dateStart, dateEnd);
        if (timeStatus.equals(TimeStatus.Absence) || timeStatus.equals(TimeStatus.SickDays) ||
        timeStatus.equals(TimeStatus.Vacation)) {
            return totalAbsentTime;
        }
        return timeSpan;
    }
}
