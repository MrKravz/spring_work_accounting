package ru.egar.spring_work_accounting.total;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.compute.kpi.ComputeKpiService;
import ru.egar.spring_work_accounting.compute.time.ComputeTimeService;
import ru.egar.spring_work_accounting.define.salary_strategy.DefineComputeSalaryService;
import ru.egar.spring_work_accounting.employee.Employee;
import ru.egar.spring_work_accounting.time_sheet.TimeStatus;

import java.time.LocalDate;
import java.util.EnumSet;

/**
 * Compute total for employee between start and end dates.
 * Use services for computing kpi and time and then depending on PaymentSystem
 * computes salary.
 **/
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ComputeTotalService {

    private final ComputeTimeService computeTimeService;
    private final ComputeKpiService computeKpiService;
    private final DefineComputeSalaryService defineComputeSalaryService;

    public Total computeTotal(Employee employee, LocalDate dateStart, LocalDate dateEnd) {
        var timeStatuses = EnumSet.allOf(TimeStatus.class);
        final int totalWorkedTime = timeStatuses.stream().mapToInt(x -> computeTotalTime(x, employee, dateStart, dateEnd)).sum();
        final int kpiPercentage = computeKpiService.computeKpi(employee, dateStart, dateEnd);
        var strategy = defineComputeSalaryService.defineStrategy(employee.getPaymentSystem());
        final float totalSalary = strategy.computeSalary(employee, dateStart, dateEnd);
        return new Total(totalWorkedTime, kpiPercentage, totalSalary, LocalDate.now(), employee);
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
