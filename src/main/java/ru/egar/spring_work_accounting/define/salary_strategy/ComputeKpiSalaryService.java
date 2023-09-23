package ru.egar.spring_work_accounting.define.salary_strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.compute.kpi.ComputeKpiService;
import ru.egar.spring_work_accounting.employee.Employee;

import java.time.LocalDate;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ComputeKpiSalaryService implements ComputeSalary {

    private final ComputeKpiService computeKpiService;

    @Override
    public float computeSalary(Employee employee, LocalDate dateStart, LocalDate dateEnd) {
        var kpi = computeKpiService.computeKpi(employee, dateStart, dateEnd);
        final int fixedPercent = 30;
        final int percentDivision = 100;
        if (kpi < fixedPercent) {
            return employee.getKpiRate().getAgreedSalary() / percentDivision * fixedPercent;
        }
        final int agreedKpi = 100;
        if (kpi < agreedKpi) {
            return employee.getKpiRate().getAgreedSalary() / percentDivision * kpi;
        }
        final int flexiblePercent = 70;
        var flexibleSalary = employee.getKpiRate().getAgreedSalary() / percentDivision * flexiblePercent;
        var incrementSalary = flexibleSalary / percentDivision * kpi - agreedKpi;
        return employee.getKpiRate().getAgreedSalary() + incrementSalary;
    }
}
