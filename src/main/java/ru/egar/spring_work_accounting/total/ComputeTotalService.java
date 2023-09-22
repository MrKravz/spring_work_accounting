package ru.egar.spring_work_accounting.total;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.employee.EmployeeNotFoundException;
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
@Service
@Transactional(readOnly = true)
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
        var employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        var timeStatuses = timeSheetRepository.findDistinctByTimeStatus();
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
        if (timeStatus.equals(TimeStatus.Absence) || timeStatus.equals(TimeStatus.SickDays) ||
        timeStatus.equals(TimeStatus.Vacation)) {
            return timeSpan;
        }
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
