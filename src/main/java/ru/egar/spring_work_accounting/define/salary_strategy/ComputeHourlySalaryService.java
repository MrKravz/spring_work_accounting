package ru.egar.spring_work_accounting.define.salary_strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.compute.salary.ComputeHoursSalaryService;
import ru.egar.spring_work_accounting.compute.time.ComputeTimeService;
import ru.egar.spring_work_accounting.employee.Employee;
import ru.egar.spring_work_accounting.rate.hour_rate.HourRate;
import ru.egar.spring_work_accounting.rate.hour_rate.HourRateNotFoundException;
import ru.egar.spring_work_accounting.time_sheet.TimeStatus;

import java.time.LocalDate;
import java.util.EnumSet;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ComputeHourlySalaryService implements ComputeSalary {

    private final ComputeTimeService computeTimeService;
    private final ComputeHoursSalaryService computeHoursSalaryService;

    @Override
    public float computeSalary(Employee employee, LocalDate dateStart, LocalDate dateEnd) {
        if (employee.getHourRate() == null) {
            throw new HourRateNotFoundException();
        }
        var timeStatuses = EnumSet.allOf(TimeStatus.class);
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
