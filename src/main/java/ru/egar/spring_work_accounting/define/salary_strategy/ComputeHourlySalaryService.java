package ru.egar.spring_work_accounting.define.salary_strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.compute.salary.ComputeHoursSalaryService;
import ru.egar.spring_work_accounting.compute.time.ComputeTimeService;
import ru.egar.spring_work_accounting.employee.Employee;
import ru.egar.spring_work_accounting.hour_rate.HourRate;
import ru.egar.spring_work_accounting.time_sheet.TimeSheetRepository;
import ru.egar.spring_work_accounting.time_sheet.TimeStatus;

import java.time.LocalDate;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ComputeHourlySalaryService implements ComputeSalary {

    private final TimeSheetRepository timeSheetRepository;
    private final ComputeTimeService computeTimeService;
    private final ComputeHoursSalaryService computeHoursSalaryService;

    @Override
    public float computeSalary(Employee employee, LocalDate dateStart, LocalDate dateEnd) {
        var timeStatuses = timeSheetRepository.findDistinctByTimeStatus();
        return (float) timeStatuses
                .stream()
                .mapToDouble(timeStatus -> {
                    var timeSpan = computeTotalTime(timeStatus, employee, dateStart, dateEnd);
                    return computeTotalSalary(employee.getHourRate(), timeSpan, timeStatus);
                })
                .sum();
    }

    private int computeTotalTime(TimeStatus timeStatus, Employee employee, LocalDate dateStart, LocalDate dateEnd) {
        return computeTimeService.computeTime(employee, timeStatus, dateStart, dateEnd);
    }

    private float computeTotalSalary(HourRate hourRate, int time, TimeStatus timeStatus) {
        return computeHoursSalaryService.computeHoursSalary(hourRate, time, timeStatus);
    }
}
