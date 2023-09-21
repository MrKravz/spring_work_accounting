package ru.egar.spring_work_accounting.total;

import lombok.RequiredArgsConstructor;
import ru.egar.spring_work_accounting.employee.EmployeeRepository;
import ru.egar.spring_work_accounting.rate.Rate;
import ru.egar.spring_work_accounting.time_sheet.TimeSheetRepository;
import ru.egar.spring_work_accounting.time_sheet.TimeStatus;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Compute total for employee between start and end dates.
 * Uses both ComputeTimeService for computing spent time and
 * ComputeSalaryService for computing salary by that time and employee rate.
 **/
@RequiredArgsConstructor
public class ComputeTotalService {

    private final ComputeSalaryService computeSalaryService;
    private final ComputeTimeService computeTimeService;
    private final EmployeeRepository employeeRepository;
    private final TimeSheetRepository timeSheetRepository;
    private int totalSalary = 0;
    private int totalWorkedTime = 0;
    private int kpiPercentage;

    public Total computeTotal(UUID employeeId, LocalDate dateStart, LocalDate dateEnd) {
        var employee = employeeRepository.findEmployeeById(employeeId);
        if (employee.isEmpty()) {
            throw new RuntimeException();
        }
        var timeStatuses = timeSheetRepository.findDistinctTimeStatuses();
        for (var timeStatus : timeStatuses) {
            var timeSpan = computeTotalTime(timeStatus, employeeId, dateStart, dateEnd);
            computeTotalSalary(employee.get().getRate(), timeSpan, timeStatus);
        }
        return new Total(UUID.randomUUID(), totalWorkedTime, kpiPercentage, totalSalary, LocalDate.now(), employee.get());
    }

    /**
     * Sub method for compute total. Created to make logic more clear and understandable.
     * Set total times and returns them depending on time status.
     **/
    private int computeTotalTime(TimeStatus timeStatus, UUID id, LocalDate dateStart, LocalDate dateEnd) {
        var timeSpan = computeTimeService.computeTime(id, timeStatus, dateStart, dateEnd);
        totalWorkedTime += timeSpan;
        return timeSpan;
    }

    /**
     * Sub method for compute total. Created to make logic more clear and understandable.
     * Increment total salary depending on return value of computeHoursSalary.
     **/
    private void computeTotalSalary(Rate rate, int time, TimeStatus timeStatus) {
        totalSalary += computeSalaryService.computeHoursSalary(rate, time, timeStatus);
    }

}
