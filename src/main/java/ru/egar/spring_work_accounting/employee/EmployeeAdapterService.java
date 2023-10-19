package ru.egar.spring_work_accounting.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egar.spring_work_accounting.abstraction.services.CrudAdapterService;
import ru.egar.spring_work_accounting.rate.hour_rate.HourRateService;
import ru.egar.spring_work_accounting.rate.kpi_rate.KpiRateService;

@Service
@Transactional(readOnly = true)
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
    @Transactional
    public Long save(EmployeeRequest entity) {
        var employee = employeeRequestMapper.map(entity);
        var hourRate = hourRateService.findByPositionAndGrade(employee.getEmployeePosition(), employee.getEmployeeGrade());
        var kpiRate = kpiRateService.findByPositionAndGrade(employee.getEmployeePosition(), employee.getEmployeeGrade());
        employee.setHourRate(hourRate);
        employee.setKpiRate(kpiRate);
        employee.setIsDeleted(false);
        return employeeService.save(employee);
    }

    @Override
    @Transactional
    public Long update(EmployeeRequest entity, Long id) {
        return employeeService.update(employeeRequestMapper.map(entity), id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var employeeToDelete = employeeService.findById(id);
        employeeToDelete.setIsDeleted(true);
        employeeService.update(employeeToDelete, id);
    }

}
