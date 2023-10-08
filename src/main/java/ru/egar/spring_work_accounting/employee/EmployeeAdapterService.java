package ru.egar.spring_work_accounting.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.egar.spring_work_accounting.abstraction.services.CrudAdapterService;
import ru.egar.spring_work_accounting.rate.hour_rate.HourRateService;
import ru.egar.spring_work_accounting.rate.kpi_rate.KpiRateService;

@Service
@RequiredArgsConstructor
public class EmployeeAdapterService implements CrudAdapterService<EmployeeRequest, EmployeeDto, Long> {

    private final EmployeeService employeeService;
    private final HourRateService hourRateService;
    private final KpiRateService kpiRateService;
    private final EmployeeRequestMapper employeeRequestMapper;
    private final EmployeeDtoMapper employeeDtoMapper;

    @Override
    public EmployeeDto findById(Long id) {
        return employeeDtoMapper.map(employeeService.findById(id));
    }

    @Override
    public Long save(EmployeeRequest entity) {
        var employee = employeeRequestMapper.map(entity);
        var hourRate = hourRateService.findByPositionAndGrade(employee.getEmployeePosition(), employee.getEmployeeGrade());
        var kpiRate = kpiRateService.findByPositionAndGrade(employee.getEmployeePosition(), employee.getEmployeeGrade());
        employee.setHourRate(hourRate);
        employee.setKpiRate(kpiRate);
        return employeeService.save(employee);
    }

    @Override
    public Long update(EmployeeRequest entity, Long id) {
        return employeeService.update(employeeRequestMapper.map(entity), id);
    }

    @Override
    public void delete(Long id) {
        employeeService.delete(id);
    }

}
